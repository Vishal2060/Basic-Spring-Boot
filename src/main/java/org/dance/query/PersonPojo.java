package org.dance.query;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class PersonPojo {
	private String firstName;
	private String lastName;
}
