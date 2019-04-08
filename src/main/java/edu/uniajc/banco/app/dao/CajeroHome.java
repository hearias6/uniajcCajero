package edu.uniajc.banco.app.dao;
// Generated 8/04/2019 05:10:57 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import edu.uniajc.banco.app.entity.Cajero;

/**
 * Home object for domain model class Cajero.
 * @see edu.uniajc.banco.app.dao.Cajero
 * @author Hibernate Tools
 */
public class CajeroHome {

	private static final Log log = LogFactory.getLog(CajeroHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Cajero transientInstance) {
		log.debug("persisting Cajero instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Cajero instance) {
		log.debug("attaching dirty Cajero instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cajero instance) {
		log.debug("attaching clean Cajero instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Cajero persistentInstance) {
		log.debug("deleting Cajero instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cajero merge(Cajero detachedInstance) {
		log.debug("merging Cajero instance");
		try {
			Cajero result = (Cajero) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Cajero findById(int id) {
		log.debug("getting Cajero instance with id: " + id);
		try {
			Cajero instance = (Cajero) sessionFactory.getCurrentSession().get("edu.uniajc.banco.app.dao.Cajero", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Cajero instance) {
		log.debug("finding Cajero instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("edu.uniajc.banco.app.dao.Cajero")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
