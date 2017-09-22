/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dance.account;

import java.io.Serializable;
import java.util.Date;

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
import lombok.ToString;

/**
 *
 * @author vishal
 */
@Entity
@Table(name = "installment")

@DynamicUpdate

@Builder(toBuilder=true)

@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)

@EqualsAndHashCode(of = ("installmentNumber"))
@ToString(doNotUseGetters = true)
public class Installment implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "installment_number")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer installmentNumber;

    @Column(name = "installment_date")
    @Temporal(TemporalType.DATE)
    private Date installmentDate;

    @Column(name = "installment_amount")
    private Integer installmentAmount;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_number_fk", foreignKey = @ForeignKey(name = "loan_number"))
    private Loan loan;
}
