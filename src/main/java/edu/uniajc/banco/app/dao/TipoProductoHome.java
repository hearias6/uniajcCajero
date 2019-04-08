package edu.uniajc.banco.app.dao;
// Generated 8/04/2019 05:10:57 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import edu.uniajc.banco.app.entity.TipoProducto;

/**
 * Home object for domain model class TipoProducto.
 * @see edu.uniajc.banco.app.dao.TipoProducto
 * @author Hibernate Tools
 */
public class TipoProductoHome {

	private static final Log log = LogFactory.getLog(TipoProductoHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(TipoProducto transientInstance) {
		log.debug("persisting TipoProducto instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TipoProducto instance) {
		log.debug("attaching dirty TipoProducto instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TipoProducto instance) {
		log.debug("attaching clean TipoProducto instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TipoProducto persistentInstance) {
		log.debug("deleting TipoProducto instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TipoProducto merge(TipoProducto detachedInstance) {
		log.debug("merging TipoProducto instance");
		try {
			TipoProducto result = (TipoProducto) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TipoProducto findById(int id) {
		log.debug("getting TipoProducto instance with id: " + id);
		try {
			TipoProducto instance = (TipoProducto) sessionFactory.getCurrentSession()
					.get("edu.uniajc.banco.app.dao.TipoProducto", id);
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

	public List findByExample(TipoProducto instance) {
		log.debug("finding TipoProducto instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("edu.uniajc.banco.app.dao.TipoProducto")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
