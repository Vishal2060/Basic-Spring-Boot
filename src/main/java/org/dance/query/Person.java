package org.dance.query;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@XmlRootElement(name="Person")

@Entity(name = "Person")
@Table(name = "person")

@EntityListeners(PersonListener.class)

@DynamicInsert
@DynamicUpdate

@Builder

@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)

@EqualsAndHashCode(of = ("id"))
@ToString
public class Person implements Serializable {

	private static final long serialVersionUID = 721416108450220940L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "number",unique=true)
	private String number;
}
