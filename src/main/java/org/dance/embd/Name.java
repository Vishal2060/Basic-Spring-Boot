package org.dance.embd;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Name implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle__name")
	private String middleName;
	
	@Column(name="last_name")
	private String lastName;
}
