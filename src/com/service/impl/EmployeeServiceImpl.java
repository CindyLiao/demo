package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bean.Employee;
import com.dao.EmployeeDAO;
import com.service.EmployeeService;

public  class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDAO employeedao;
	public EmployeeDAO getEmployeedao() {
		return employeedao;
	}
	public void setEmployeedao(EmployeeDAO employeedao) {
		this.employeedao=employeedao;
		
	}
	public void addEmployee(Employee employee) {
		employeedao.save(employee);	
	}

	public List findByAge(String age) {
		return employeedao.findByAge(age);
	}

	public List findByGender(String gender) {
		return employeedao.findByGender(gender);
	}

	public List findByUserId(int userid) {
		return employeedao.findByUserId(userid);
	}

	public void updateEmployee(Employee employee) {
		employeedao.attachDirty(employee);
	}

	public void deleteEmployee(Employee employee) {
		employeedao.delete(employee);
	}

	public Employee findById(int employeeid) {
		return employeedao.findById(employeeid);
	}
	
	public List findAll() {
		return employeedao.findAll();
	}
	
	public int getEmployeeNum() {
		return employeedao.findAll().size();
	}
	
	public List findPositionsByEmpId(int employeeid){
		return employeedao.findPositionsByEmpId(employeeid);
	}
}
