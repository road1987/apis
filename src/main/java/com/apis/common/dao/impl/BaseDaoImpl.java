package com.apis.common.dao.impl;

import java.lang.reflect.ParameterizedType;  
import java.lang.reflect.Type;  

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.apis.common.dao.BaseDao;
import com.apis.common.HibernateUtil;
import com.apis.common.PageUtil;

public abstract class BaseDaoImpl<T> implements BaseDao<T>{
	
	
	private Class clazz;  
    
    public BaseDaoImpl() {  
        super();  
        clazz = getParameterizedTypeByParent(super.getClass());  
    }  
    
    private Class getParameterizedTypeByParent(Class clazz) {  
        Type tp = clazz.getGenericSuperclass();  
        if (tp instanceof ParameterizedType) {  
            return (Class) ((ParameterizedType) tp).getActualTypeArguments()[0];  
        } else {  
            throw new ClassCastException("this is not ParameterizedType type");  
        }  
    }  
    /**
     * 添加
     * 
     * @param obj
     */
    public void save(T obj) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
 
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
 
    /**
     * 删除
     * 
     * @param obj
     */
    public void delete(T obj) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
 
    /**
     * 修改
     * 
     * @param obj
     */
    public void update(T obj) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
 
    }
    
    
    /**
     * 根据主键查询
     * 
     * @param clazz
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
	public T getById(Serializable id) {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            T obj = (T) session.get(clazz, id);
            return obj;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    /**
     * 根据主键删除
     * 
     * @param clazz
     * @param id
     * @throws Exception 
     */
    public void deleteById(Serializable id) throws Exception {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.delete(session.get(clazz, id));
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
 
    /**
     * 根据多个属性查询
     * 
     * @param clazz
     * @param strs
     * @return
     */
    @SuppressWarnings("unchecked")
	public T getByNProperty(String... strs) {
 
        if (strs != null && strs.length != 0 && 0 != strs.length % 2) {
            StringBuffer hql = new StringBuffer("select model from "
                    + clazz.getName() + " as model where ");
            for (int i = 0; i < strs.length; i += 2) {
                hql.append(" " + strs[i] + " = " + strs[i + 1]);
            }
 
            Session session = null;
            try {
                session = HibernateUtil.getSession();
                List<T> objs = session.createQuery(hql.toString()).list();
                if (objs != null && objs.size() != 0) {
                    return objs.get(0);
                } else {
                    return null;
                }
            } finally {
                if (session != null) {
                    session.close();
                }
            }
        } else {
            return null;
        }
 
    }
 
    /**
     * 根据属性查询
     * 
     * @param clazz
     * @param pName
     * @param pValue
     * @return
     */
    @SuppressWarnings("unchecked")
	public T getUniqueByProperty(String pName, Object pValue) {
        Session session = null;
 
        try {
            session = HibernateUtil.getSession();
            String hql = "select model from " + clazz.getName()
                    + " as model where model." + pName + " = '" + pValue + "'";
            List<T> objs = session.createQuery(hql).list();
            if (objs != null && objs.size() != 0) {
                return objs.get(0);
            } else {
                return null;
            }
 
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
 
    /**
     * 根据HQL查询
     * 
     * @param hql
     * @return
     */
    @SuppressWarnings("unchecked")
	public T getUniqueByHql(String hql) {
 
        Session session = null;
 
        try {
            session = HibernateUtil.getSession();
            List<T> objs = session.createQuery(hql).list();
            if (objs != null && objs.size() != 0) {
                return objs.get(0);
            } else {
                return null;
            }
 
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
 
    /**
     * 根据SQL查询
     * 
     * @param sql
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
	public T getUniqueBySql(String sql) {
 
        Session session = null;
 
        try {
            session = HibernateUtil.getSession();
            Query query = session.createSQLQuery(sql).addEntity(clazz);
            List<T> objs = query.list();
            if (objs != null && objs.size() != 0) {
                return objs.get(0);
            } else {
                return null;
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
 
    // ////////////////////查询单个完毕////////////////
 
    /**
     * 查询所有
     */
    @SuppressWarnings("unchecked")
	public List<T> getList() {
        Session session = null;
 
        try {
            session = HibernateUtil.getSession();
           
            String hql = "select model from " + clazz.getName() + " as model ";
            List<T> list = session.createQuery(hql).list();
            return list;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
 
    /**
     * 根据属性查询 全部
     * 
     * @param clazz
     * @param pName
     * @param pValue
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<T> getListByProperty(String pName,
            Object pValue) {
        Session session = null;
 
        try {
            session = HibernateUtil.getSession(); // 获得安全session
            String hql = "select model from " + clazz.getName()
                    + " as model where model." + pName + " = '" + pValue + "'";
            return session.createQuery(hql).list();
 
        } finally {
            if (session != null) {
                session.close();
            }
        }
 
    }
 
    /**
     * 根据属性和条件查询 全部
     * 
     * @param clazz
     * @param pName
     * @param pValue
     * @param condition
     * @return
     */
    public List<T> getListByProperty(String pName,
            Object pValue, String condition) {
        Session session = null;
 
        try {
            session = HibernateUtil.getSession();
            String hql = "select model from " + clazz.getName()
                    + " as model where model." + pName + " " + condition
                    + " '%" + pValue + "%'";
            List<T> list = session.createQuery(hql).list();
            return list;
        } finally {
            if (session != null) {
                session.close();
            }
        }
 
    }
 
    /**
     * 根据多个属性模糊查询
     * 
     * @param clazz
     * @param strs
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<T> getListByNProperty(String... strs) {
 
        if (strs != null && strs.length != 0 && 0 != strs.length % 2) {
            StringBuffer hql = new StringBuffer("select model from "
                    + clazz.getName() + " as model where ");
            for (int i = 0; i < strs.length; i += 2) {
                hql.append(" " + strs[i] + " Like  %" + strs[i + 1] + "% ");
            }
 
            Session session = null;
            try {
                session = HibernateUtil.getSession();
                List<T> objs = session.createQuery(hql.toString()).list();
                return objs;
            } finally {
                if (session != null) {
                    session.close();
                }
            }
        } else {
            return null;
        }
 
    }
 
    /**
     * 根据SQL查询 全部
     * 
     * @param hql
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<T> getListByHql(String hql) {
 
        Session session = null;
 
        try {
            session = HibernateUtil.getSession();
            List<T> list = session.createQuery(hql).list();
            return list;
 
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
 
    /**
     * 根据SQL查询全部
     * 
     * @param sql
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<T> getListBySql(String sql) {
 
        Session session = null;
 
        try {
            session = HibernateUtil.getSession();
            Query query = session.createSQLQuery(sql).addEntity(clazz);
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
 
    /**
     * 分页查询全部
     * 
     * @param calzz
     * @param pageUtil
     */
    @SuppressWarnings("rawtypes")
	public void getListByPage(PageUtil pageUtil) {
        String hql = "SELECT model from " + clazz.getName() + " as model";
        getListByPage(hql, pageUtil);
    }
 
    /**
     * 根据SQL分页查询
     * 
     * @param hql
     * @param pageUtil
     */
    public void getListByPage(String hql, PageUtil pageUtil) {
        if (null == hql) {
            return;
        }
        Session session = null;
 
        try {
            session = HibernateUtil.getSession();
            Query query = session.createQuery(hql);
            query.setFirstResult(pageUtil.getFirstRec());
            query.setMaxResults(pageUtil.getPageSize());
            pageUtil.setList(query.list());
 
            String queryString = "";
            if (hql.toUpperCase().indexOf("SELECT") != -1) {
                int i = query.getQueryString().toUpperCase().indexOf("FROM");
                queryString = "Select count(*) "
                        + hql.substring(i, hql.length());
            } else {
                queryString = "Select count(*) " + hql;
            }
            // 去掉ORDER BY 的部分
            int j = queryString.toUpperCase().lastIndexOf("ORDER");
            if (j != -1) {
                queryString = queryString.substring(0, j);
            }
            Query cquery = session.createQuery(queryString);
            cquery.setCacheable(true);
            int recTotal = ((Integer) cquery.iterate().next()).intValue();
            pageUtil.setRecTotal(recTotal);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    //统计
    public int getTotalCount(){
    	return 0;
    }
}