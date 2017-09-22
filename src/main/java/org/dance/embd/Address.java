package org.dance.embd;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="adress_line1")
	private String line1;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="pin_code")
	private String pinCode;
}
