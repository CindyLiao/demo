package com.dao.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.Position;
import com.dao.PositionDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * Position entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bean.Position
 * @author MyEclipse Persistence Tools
 */

public class PositionDAOImpl extends HibernateDaoSupport implements PositionDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PositionDAOImpl.class);
	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.dao.PositionDAO#save(com.bean.Position)
	 */
	public void save(Position transientInstance) {
		log.debug("saving Position instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.PositionDAO#delete(com.bean.Position)
	 */
	public void delete(Position persistentInstance) {
		log.debug("deleting Position instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.PositionDAO#findById(java.lang.Integer)
	 */
	public Position findById(java.lang.Integer id) {
		log.debug("getting Position instance with id: " + id);
		try {
			Position instance = (Position) getHibernateTemplate().get(
					"com.bean.Position", id);
			
			return instance;
			
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.PositionDAO#findByExample(com.bean.Position)
	 */
	public List findByExample(Position instance) {
		log.debug("finding Position instance by example");
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
	 * @see com.dao.PositionDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List<Object> findByProperty(String propertyName, Object value) {
		log.debug("finding Position instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Position as model inner join fetch model.employees where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.dao.PositionDAO#findByRoleId(java.lang.String, java.lang.Object)
	 */
	public List findByRoleId(String propertyName, Object value) {
		log.debug("finding Position instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Position as model inner join model.employees where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.PositionDAO#findByEmpId(java.lang.Object)
	 */
	public List findByEmpId(Object empId) {
		return findByProperty(EMP_ID, empId);
	}
	
	/* (non-Javadoc)
	 * @see com.dao.PositionDAO#findByPrivilege(java.lang.Object)
	 */
	public List findByPrivilege(Object privilege) {
		return findByProperty(PRIVILEGE, privilege);
	}

	/* (non-Javadoc)
	 * @see com.dao.PositionDAO#findByPosName(java.lang.Object)
	 */
	public List findByPosName(Object posName) {
		log.debug("finding all Position instances and employees");
		try {
			String queryString = "select distinct p from Position p inner join fetch p.employees where p.posName=?";
			return getHibernateTemplate().find(queryString, posName);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.dao.PositionDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Position instances");
		try {
			String queryString = "from Position";
			List list=getHibernateTemplate().find(queryString);
			return list;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.PositionDAO#merge(com.bean.Position)
	 */
	public Position merge(Position detachedInstance) {
		log.debug("merging Position instance");
		try {
			Position result = (Position) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.PositionDAO#attachDirty(com.bean.Position)
	 */
	public void attachDirty(Position instance) {
		log.debug("attaching dirty Position instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.PositionDAO#attachClean(com.bean.Position)
	 */
	public void attachClean(Position instance) {
		log.debug("attaching clean Position instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PositionDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PositionDAO) ctx.getBean("PositionDAO");
	}
	
	/* (non-Javadoc)
	 * @see com.dao.PositionDAO#getPositions()
	 */
	public List<Object[]> getPositions() {
		log.debug("finding all Position instances and organization , Roles");
		try {
			String queryString = "from Position p inner join p.organization inner join p.role";
			List<Object[]> list=getHibernateTemplate().find(queryString);
			return list;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
}