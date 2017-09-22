package org.dance.embd;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "enquiry")
@Getter
@Setter
public class Enquiry extends Person implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="enquiry_code")
	private Integer id; 
	
	@Embedded
	private Gaurdian gaurdian;
	
	@Temporal(TemporalType.DATE)
	private Date enquiryDate;
}
