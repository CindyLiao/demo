package com.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Ability entity. @author MyEclipse Persistence Tools
 */

public class Ability implements java.io.Serializable {

	// Fields

	private Integer abiId;
	private String abiName;
	private String abiDesc;
	private Set employees = new HashSet(0);

	// Constructors

	/** default constructor */
	public Ability() {
	}

	/** full constructor */
	public Ability(String abiName, String abiDesc, Set employees) {
		this.abiName = abiName;
		this.abiDesc = abiDesc;
		this.employees = employees;
	}

	// Property accessors

	public Integer getAbiId() {
		return this.abiId;
	}

	public void setAbiId(Integer abiId) {
		this.abiId = abiId;
	}

	public String getAbiName() {
		return this.abiName;
	}

	public void setAbiName(String abiName) {
		this.abiName = abiName;
	}

	public String getAbiDesc() {
		return this.abiDesc;
	}

	public void setAbiDesc(String abiDesc) {
		this.abiDesc = abiDesc;
	}

	public Set getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set employees) {
		this.employees = employees;
	}

}