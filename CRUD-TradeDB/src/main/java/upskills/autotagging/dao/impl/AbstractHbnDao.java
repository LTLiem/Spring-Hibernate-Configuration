package upskills.autotagging.dao.impl;


import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;

import upskills.autotagging.dao.Dao;

public abstract class AbstractHbnDao<T extends Object> implements Dao<T> {
	
	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> domainClass;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
		
	@SuppressWarnings("unchecked")
	private Class<T> getDomainClass() {
		if(domainClass == null) {
			ParameterizedType thisType = 
					(ParameterizedType) getClass().getGenericSuperclass();
			this.domainClass = (Class<T>) thisType.getActualTypeArguments()[0];
		}
		return domainClass;
	}
	
	private String getDomainClassName() {
		return this.getDomainClass().getName();
	}
	
	 public void create(T t) {
		 Method method = ReflectionUtils.findMethod(
				 this.getDomainClass(), "setTimeCreated",
				 new Class[] { Date.class });
		 method = ReflectionUtils.findMethod(
				 this.getDomainClass(), "setTimeUpdated",
				 new Class[] { Date.class });
		 try {
			 method.invoke(t, new Date());
		 } catch (Exception e) {
			 e.getCause();
		 }
		 this.getSession().save(t);
	 }
		
	 public void delete(T t) {
		 this.getSession().delete(t);
	 }
	 
	 public void deleteById(Serializable id) {
		 this.delete(load(id));
	 }
	 
	 public void deleteAll() {
		 this.getSession().createQuery("delete " + 
				 			getDomainClassName()).executeUpdate();
	 }
	
	 public void update(T t) {
		 Method method = ReflectionUtils.findMethod(
				 this.getDomainClass(), "setTimeUpdated",
				 new Class[] { Date.class });		
		 try {
			 method.invoke(t, new Date());
		 } catch (Exception e) {
			 e.getCause();
		 }
		 this.getSession().update(t);
	 }
	
	 @SuppressWarnings("unchecked")
	 public T get(Serializable id) {
		 return (T)this.getSession().get(getDomainClass(), id);
	 }
	 
	 @SuppressWarnings("unchecked")
	 public T load(Serializable id) {
		 return (T)this.getSession().load(getDomainClass(), id);
	 }
	 
	 @SuppressWarnings("unchecked")
	 public List<T> getAll() {
		 return this.getSession().createQuery("from " + getDomainClassName()).list();
	 }
	
	 public long count() {
		 return (Long)this.getSession().createQuery(
				 			"select count(*) from " + 
		 					getDomainClassName()).uniqueResult();
	 }
	 
	 public boolean exists(Serializable id) {
		 return (this.get(id) != null);
	 }
	
}