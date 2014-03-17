package com.apis.common.service.impl;

import java.util.List;

import com.apis.common.dao.BaseDao;
import com.apis.common.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {
	protected BaseDao<T> dao;
	
	public void save(T obj) {
		// TODO Auto-generated method stub
		dao.save(obj);
	}
	
	public void delete(T obj) {
		// TODO Auto-generated method stub
		dao.delete(obj);
	}
	
	public void deleteById(int id){
		try {
			dao.deleteById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(T obj) {
		// TODO Auto-generated method stub
		dao.update(obj);
	}

	public T getById(int id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	public List<T> getList(){
		return dao.getList();
	}
	
	public void setDao(BaseDao<T> dao){
		this.dao = dao;
	}
}
