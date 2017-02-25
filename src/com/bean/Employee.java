package com.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Employee entity. @author MyEclipse Persistence Tools
 */

public class Employee implements java.io.Serializable {

	// Fields

	private Integer empId;
	private String firstName;
	private Integer age;
	private String gender;
	private Integer userId;
	private String password;
	private String lastName;
	private Set abilities = new HashSet(0);
	private Set positions = new HashSet(0);
	private Set organizations = new HashSet(0);

	// Constructors

	/** default constructor */
	public Employee() {
	}

	/** minimal constructor */
	public Employee(Integer empId) {
		this.empId = empId;
	}

	/** full constructor */
	public Employee(Integer empId, String firstName, Integer age,
			String gender, Integer userId, String password, String lastName,
			Set abilities, Set positions, Set organizations) {
		this.empId = empId;
		this.firstName = firstName;
		this.age = age;
		this.gender = gender;
		this.userId = userId;
		this.password = password;
		this.lastName = lastName;
		this.abilities = abilities;
		this.positions = positions;
		this.organizations = organizations;
	}

	// Property accessors

	public Integer getEmpId() {
		return this.empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set getAbilities() {
		return this.abilities;
	}

	public void setAbilities(Set abilities) {
		this.abilities = abilities;
	}

	public Set getPositions() {
		return this.positions;
	}

	public void setPositions(Set positions) {
		this.positions = positions;
	}

	public Set getOrganizations() {
		return this.organizations;
	}

	public void setOrganizations(Set organizations) {
		this.organizations = organizations;
	}

}