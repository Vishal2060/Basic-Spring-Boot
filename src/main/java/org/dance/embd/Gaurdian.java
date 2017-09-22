package org.dance.embd;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Gaurdian implements Serializable {
	private static final long serialVersionUID = 1L;

	@AttributeOverrides(value = {
			@AttributeOverride(name = "firstName", column = @Column(name = "gaurdian_first_name")),
			@AttributeOverride(name = "middleName", column = @Column(name = "gaurdian_middle_name")),
			@AttributeOverride(name = "lastName", column = @Column(name = "gaurdian_last_name")) })
	private Name name;

	@AttributeOverrides(value = { @AttributeOverride(name = "mobileNo", column = @Column(name = "gaurdian_mobile_no")),
			@AttributeOverride(name = "email", column = @Column(name = "gaurdian_email")) })
	private Contact contact;
}
