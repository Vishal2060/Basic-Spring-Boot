package org.dance.jasper;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.jasperreports.engine.JRException;

@Controller
@RequestMapping("/report/")
public class ReportController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ReportComponent reportComponent;

	/**
	 * 
	 * @param format
	 * @return ModelAndView
	 * @throws ReportFormatNotFoundException
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{format}/getpdf")
	public ModelAndView generatePdfReport(@PathVariable(name = "format") String format) throws ReportFormatNotFoundException {
		Map<String,Object> parameters = new HashMap<>();
		
		parameters.put("company", "Funk and Fusion");
		parameters.put("date", new Date());
		
		return reportComponent.getReport("chathuranga-sample-report.jrxml", format,
				userDao.retrieveAllRegisteredUsers(), parameters);
	}
	
	@GetMapping("/pdfReport")
	@ResponseBody
	public void reportPdf(HttpServletResponse response) throws IOException, JRException {
		reportComponent.getPdfReport("chathuranga-sample-report.jrxml", response, userDao.retrieveAllRegisteredUsers(), null);
	}
	
}