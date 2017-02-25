package com.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.Employee;
import com.dao.EmployeeDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * Employee entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bean.Employee
 * @author MyEclipse Persistence Tools
 */

public class EmployeeDAOImpl extends HibernateDaoSupport implements EmployeeDAO {
	private static final Logger log = LoggerFactory
			.getLogger(EmployeeDAOImpl.class);
	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.dao.EmployeeDAO#save(com.model.Employee)
	 */
	public void save(Employee transientInstance) {
		log.debug("saving Employee instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.EmployeeDAO#delete(com.model.Employee)
	 */
	public void delete(Employee persistentInstance) {
		log.debug("deleting Employee instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.EmployeeDAO#findById(java.lang.Integer)
	 */
	public Employee findById(java.lang.Integer id) {
		log.debug("getting Employee instance with id: " + id);
		try {
			Employee instance = (Employee) getHibernateTemplate().get(
					"com.bean.Employee", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	

	/* (non-Javadoc)
	 * @see com.dao.EmployeeDAO#findByExample(com.model.Employee)
	 */
	public List findByExample(Employee instance) {
		log.debug("finding Employee instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.EmployeeDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List<Object> findByProperty(String propertyName, Object value) {
		log.debug("finding Employee instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Employee as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.dao.EmployeeDAO#findByOrgId(java.lang.String, java.lang.Object)
	 */
	public List<Object> findByOrgId(String propertyName, Object value) {
		log.debug("finding Employee instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Employee as model inner join fetch model.organizations where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.EmployeeDAO#findByFirstName(java.lang.Object)
	 */
	public List<Object> findByFirstName(Object firstName) {
		return findByProperty(FIRST_NAME, firstName);
	}

	/* (non-Javadoc)
	 * @see com.dao.EmployeeDAO#findByAge(java.lang.Object)
	 */
	public List findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	/* (non-Javadoc)
	 * @see com.dao.EmployeeDAO#findByGender(java.lang.Object)
	 */
	public List findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	/* (non-Javadoc)
	 * @see com.dao.EmployeeDAO#findByUserId(java.lang.Object)
	 */
	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	/* (non-Javadoc)
	 * @see com.dao.EmployeeDAO#findByPassword(java.lang.Object)
	 */
	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	/* (non-Javadoc)
	 * @see com.dao.EmployeeDAO#findByLastName(java.lang.Object)
	 */
	public List findByLastName(Object lastName) {
		return findByProperty(LAST_NAME, lastName);
	}

	/* (non-Javadoc)
	 * @see com.dao.EmployeeDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Employee instances");
		try {
			String queryString = "from Employee";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.EmployeeDAO#merge(com.model.Employee)
	 */
	public Employee merge(Employee detachedInstance) {
		log.debug("merging Employee instance");
		try {
			Employee result = (Employee) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.EmployeeDAO#attachDirty(com.model.Employee)
	 */
	public void attachDirty(Employee instance) {
		log.debug("attaching dirty Employee instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.EmployeeDAO#attachClean(com.model.Employee)
	 */
	public void attachClean(Employee instance) {
		log.debug("attaching clean Employee instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EmployeeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (EmployeeDAO) ctx.getBean("EmployeeDAO");
	}
	
	/**
	 * 根据empId查找positions
	 */
	public List findPositionsByEmpId(int employeeid) {
		try {
			String queryString = "from Employee as model inner join fetch model.positions where model.empId = ?";
			List list = getHibernateTemplate().find(queryString, employeeid);
			return list;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
}