package edu.uniajc.banco.app.dao;
// Generated 8/04/2019 05:10:57 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import edu.uniajc.banco.app.entity.LogTrasaccion;

/**
 * Home object for domain model class LogTrasaccion.
 * @see edu.uniajc.banco.app.dao.LogTrasaccion
 * @author Hibernate Tools
 */
public class LogTrasaccionHome {

	private static final Log log = LogFactory.getLog(LogTrasaccionHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(LogTrasaccion transientInstance) {
		log.debug("persisting LogTrasaccion instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(LogTrasaccion instance) {
		log.debug("attaching dirty LogTrasaccion instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LogTrasaccion instance) {
		log.debug("attaching clean LogTrasaccion instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(LogTrasaccion persistentInstance) {
		log.debug("deleting LogTrasaccion instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LogTrasaccion merge(LogTrasaccion detachedInstance) {
		log.debug("merging LogTrasaccion instance");
		try {
			LogTrasaccion result = (LogTrasaccion) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LogTrasaccion findById(int id) {
		log.debug("getting LogTrasaccion instance with id: " + id);
		try {
			LogTrasaccion instance = (LogTrasaccion) sessionFactory.getCurrentSession()
					.get("edu.uniajc.banco.app.dao.LogTrasaccion", id);
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

	public List findByExample(LogTrasaccion instance) {
		log.debug("finding LogTrasaccion instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("edu.uniajc.banco.app.dao.LogTrasaccion")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
