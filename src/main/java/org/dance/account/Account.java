/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dance.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "account")

@DynamicUpdate

@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)

@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)

@EqualsAndHashCode(of = ("accountNumber"))
@ToString(doNotUseGetters = true)
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "account_number")
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer accountNumber;

	@Column(name = "account_holder")
	String accountHolder;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Builder.Default
	List<Loan> loans = new ArrayList<>();

	@Enumerated(EnumType.STRING)
	@Column(name="status")
	Status status;
}
