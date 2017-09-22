package org.dance.embd;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Contact implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name="mobile_no")
	private String mobileNo;
	
	@Column(name="email")
	private String email;
}
