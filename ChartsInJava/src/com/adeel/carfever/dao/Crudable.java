package com.adeel.carfever.dao;

public interface Crudable <T, S> {
	
	void insert(T entity);
	
	void update(T entity);
	
	void delete(T entity);
	
	T get(S id);

}
