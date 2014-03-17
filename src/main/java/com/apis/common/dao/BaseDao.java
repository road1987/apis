package com.apis.common.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T>{
	public void save( T t );
	public void delete( T t );
	public void update( T t);
	public List<T> getList();
	
	public int getTotalCount();
	
	public T getById( Serializable id );
	
	
	public void deleteById(Serializable id) throws Exception;
}
