package com.apis.common.service;

import java.util.List;

public interface BaseService<T> {
	
     public void save(T obj);
     public void delete(T obj);
     public void deleteById(int id);
     public void update(T obj);
     public T getById(int id);
     
     public List<T> getList();
}