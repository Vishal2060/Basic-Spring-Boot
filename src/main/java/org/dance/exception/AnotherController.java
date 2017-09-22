package org.dance.exception;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnotherController {
	@RequestMapping(value = "/another/sql", method = RequestMethod.GET)
	public String getSqlException() throws Exception {
		throw new SQLException();
	}

	@RequestMapping(value = "/another/io", method = RequestMethod.GET)
	public String getIoException() throws Exception {
		throw new IOException();
	}

	@RequestMapping(value = "/another/null", method = RequestMethod.GET)
	public String getNullPointerException() throws Exception {
		throw new NullPointerException();
	}

}
