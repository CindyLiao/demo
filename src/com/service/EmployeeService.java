package com.service;

import java.util.List;

import com.bean.Employee;
import com.dao.EmployeeDAO;

public interface EmployeeService {
	
	public abstract EmployeeDAO getEmployeedao();
	
	public abstract void setEmployeedao(EmployeeDAO employeedao);

	public abstract void addEmployee(Employee employee);

	public abstract void updateEmployee(Employee employee);
	
	public abstract void deleteEmployee(Employee employee);
	
	public abstract List findByAge(String age);
	
	public abstract List findByGender(String gender);
	
	public abstract List findByUserId(int userid);
	
	public abstract Employee findById(int employeeid);
	
	public abstract List findAll();
	
	public abstract int getEmployeeNum();
	
	public abstract List findPositionsByEmpId(int employeeid);

}
