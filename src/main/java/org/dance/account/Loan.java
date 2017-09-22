/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dance.account;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

/**
 *
 * @author vishal
 */
@Entity
@Table(name = "loan")

@DynamicUpdate

@Builder(toBuilder = true)

@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)

@EqualsAndHashCode(of = ("loanNumber"))
@ToString(doNotUseGetters = true)
public class Loan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "loan_number")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer loanNumber;

	@Column(name = "loan_date")
	@Temporal(TemporalType.DATE)
	private Date loanDate;

	@Column(name = "loan_amount")
	private Integer loanAmount;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "account_number_fk", foreignKey = @ForeignKey(name = "account_number"))
	private Account account;

	@Singular
	@OneToMany(mappedBy = "loan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Installment> installments;
}
