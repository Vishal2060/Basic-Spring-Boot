package org.dance.jasper;

import java.io.Serializable;
import java.util.Date;

public class CommonRef implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String company;
	private Date date;
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
