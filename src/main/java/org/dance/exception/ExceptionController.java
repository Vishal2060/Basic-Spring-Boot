package org.dance.exception;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

	@RequestMapping(value = "/exception/sql", method = RequestMethod.GET)
	public String getSqlException() throws Exception {
		throw new SQLException();
	}

	@RequestMapping(value = "/exception/io", method = RequestMethod.GET)
	public String getIoException() throws Exception {
		throw new IOException();
	}

	@RequestMapping(value = "/exception/null", method = RequestMethod.GET)
	public String getNullPointerException() throws Exception {
		throw new NullPointerException();
	}

	@ExceptionHandler(NullPointerException.class)
	public String handleEmployeeNotFoundException(HttpServletRequest request, Exception ex) {
		return "Null Pointer Exception";
	}
}
