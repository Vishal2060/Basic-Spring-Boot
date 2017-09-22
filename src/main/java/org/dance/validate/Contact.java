package org.dance.validate;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity(name = "Contact")
//@Table(name = "contact")

@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)

@EqualsAndHashCode(of = ("userId"))
@ToString()
public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5468768308293888010L;
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "contact_id")
	private Integer userId;

	@NonNull
	@NotBlank(message = "This is required.")
	@Size(min = 2, max = 30, message = "This is must be in length of {min} to {max} characters")
	//@Column(name = "first_name", nullable = false)
	private String firstName;

	@NonNull
	@NotBlank(message = "This is required.")
	//@Column(name = "last_name", nullable = false)
	private String lastName;

	@NonNull
	@NotNull(message = "This is required.")
	@Min(value = 18, message = "You are not eligible.")
	//@Column(name = "age", nullable = false)
	private Integer age;

	@NonNull
	@NotBlank(message = "This is required.")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "This is not a valid phone number.")
	//@Column(name = "phone_number", nullable = false, unique = true)
	private String phoneNumber;

	@Email(message = "This is not a valid Email Address.")
	//@Column(name = "email_address", unique = true)
	private String emailAddress;
}
