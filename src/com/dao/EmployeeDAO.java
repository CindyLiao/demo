package com.dao;

import java.util.List;

import com.bean.Employee;

public interface EmployeeDAO {

	// property constants
	public static final String FIRST_NAME = "firstName";
	public static final String AGE = "age";
	public static final String GENDER = "gender";
	public static final String USER_ID = "userId";
	public static final String PASSWORD = "password";
	public static final String LAST_NAME = "lastName";

	public abstract void save(Employee transientInstance);

	public abstract void delete(Employee persistentInstance);

	public abstract Employee findById(java.lang.Integer id);

	public abstract List findByExample(Employee instance);

	public abstract List<Object> findByProperty(String propertyName,
			Object value);

	public abstract List<Object> findByOrgId(String propertyName, Object value);

	public abstract List<Object> findByFirstName(Object firstName);

	public abstract List findByAge(Object age);

	public abstract List findByGender(Object gender);

	public abstract List findByUserId(Object userId);

	public abstract List findByPassword(Object password);

	public abstract List findByLastName(Object lastName);

	public abstract List findAll();

	public abstract Employee merge(Employee detachedInstance);

	public abstract void attachDirty(Employee instance);

	public abstract void attachClean(Employee instance);
	
	public abstract List findPositionsByEmpId(int employeeid);

}