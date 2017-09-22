package org.dance.jasper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsCsvView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsHtmlView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsXlsView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsXlsxView;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@Component
public class ReportComponent {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	ObjectMapper objectMapper;

	private static final Logger logger = LoggerFactory.getLogger(ReportComponent.class);

	private static final String INITIAL_PATH_1 = "classpath:/templates/JasperTemplate/";
	private static final String INITIAL_PATH_2 = "/templates/JasperTemplate/";

	private Map<String, Object> initialParameters = new HashMap<>();

	public ReportComponent() {
		initialParameters.put("company", "Funck and Fusion");
		initialParameters.put("address", "Sadashiv Peth, Pune - 30");
		initialParameters.put("phone", "(020) 26677888");
		initialParameters.put("website", "www.funkandfusion.com");
	}

	public ModelAndView getReport(String path, String format, Collection<?> collection, Map<String, ?> parameters)
			throws ReportFormatNotFoundException {

		Map<String, Object> model = new HashMap<>();
		JRDataSource JRdataSource = new JRBeanCollectionDataSource(collection);
		model.put("datasource", JRdataSource);
		model.putAll(initialParameters);
		model.putAll(parameters);

		if (format.equals("pdf")) {
			JasperReportsPdfView view = new JasperReportsPdfView();
			view.setReportDataKey("datasource");
			view.setUrl(INITIAL_PATH_1 + path);
			view.setApplicationContext(applicationContext);
			logger.info(String.format("%s Document Generated from Template %s", "PDF", path));
			return new ModelAndView(view, model);
		} else if (format.equals("xls")) {
			JasperReportsXlsView view = new JasperReportsXlsView();
			view.setReportDataKey("datasource");
			view.setUrl(INITIAL_PATH_1 + path);
			view.setApplicationContext(applicationContext);
			logger.info(String.format("%s Document Generated from Template %s", "XLS", path));
			return new ModelAndView(view, model);
		} else if (format.equals("xlsx")) {
			JasperReportsXlsxView view = new JasperReportsXlsxView();
			view.setReportDataKey("datasource");
			view.setUrl(INITIAL_PATH_1 + path);
			view.setApplicationContext(applicationContext);
			logger.info(String.format("%s Document Generated from Template %s", "XLSX", path));
			return new ModelAndView(view, model);
		} else if (format.equals("csv")) {
			JasperReportsCsvView view = new JasperReportsCsvView();
			view.setReportDataKey("datasource");
			view.setUrl(INITIAL_PATH_1 + path);
			view.setApplicationContext(applicationContext);
			logger.info(String.format("%s Document Generated from Template %s", "CSV", path));
			return new ModelAndView(view, model);
		} else if (format.equals("html")) {
			JasperReportsHtmlView view = new JasperReportsHtmlView();
			view.setReportDataKey("datasource");
			view.setUrl(INITIAL_PATH_1 + path);
			view.setApplicationContext(applicationContext);
			logger.info(String.format("%s Document Generated from Template %s", "HTML", path));
			return new ModelAndView(view, model);
		} else {
			throw new ReportFormatNotFoundException();
		}

	}

	@SuppressWarnings("unchecked")
	public void getPdfReport(String path, HttpServletResponse response, Collection<?> collection, Object object) {
		try {
			InputStream jasperStream = this.getClass().getResourceAsStream(INITIAL_PATH_2 + path);
			JasperDesign jasperDesign = JRXmlLoader.load(jasperStream);
			JasperReport report = JasperCompileManager.compileReport(jasperDesign);

			Map<String, Object> parameters = new HashMap<>();
			JRDataSource jrDataSource = new JRBeanCollectionDataSource(collection);
			parameters.put("datasource", jrDataSource);
			parameters.putAll(initialParameters);

			if (object != null)
				parameters.putAll(objectMapper.convertValue(object, Map.class));

			JasperPrint print = JasperFillManager.fillReport(report, parameters, jrDataSource);

			response.setContentType("application/x-pdf");
			response.setHeader("Content-Disposition", "inline: filename=Users.pdf");

			final OutputStream outputStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(print, outputStream);
		} catch (JRException | IOException e) {
			e.printStackTrace();
		}
	}

}
