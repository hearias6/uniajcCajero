package edu.uniajc.banco.app.dao;
// Generated 8/04/2019 05:10:57 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import edu.uniajc.banco.app.entity.Tarjeta;

/**
 * Home object for domain model class Tarjeta.
 * @see edu.uniajc.banco.app.dao.Tarjeta
 * @author Hibernate Tools
 */
public class TarjetaHome {

	private static final Log log = LogFactory.getLog(TarjetaHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Tarjeta transientInstance) {
		log.debug("persisting Tarjeta instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Tarjeta instance) {
		log.debug("attaching dirty Tarjeta instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tarjeta instance) {
		log.debug("attaching clean Tarjeta instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Tarjeta persistentInstance) {
		log.debug("deleting Tarjeta instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tarjeta merge(Tarjeta detachedInstance) {
		log.debug("merging Tarjeta instance");
		try {
			Tarjeta result = (Tarjeta) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tarjeta findById(int id) {
		log.debug("getting Tarjeta instance with id: " + id);
		try {
			Tarjeta instance = (Tarjeta) sessionFactory.getCurrentSession().get("edu.uniajc.banco.app.dao.Tarjeta", id);
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

	public List findByExample(Tarjeta instance) {
		log.debug("finding Tarjeta instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("edu.uniajc.banco.app.dao.Tarjeta")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}