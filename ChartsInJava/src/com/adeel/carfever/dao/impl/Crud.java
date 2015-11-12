package com.adeel.carfever.dao.impl;

import java.sql.Connection;

import com.adeel.carfever.dao.Crudable;

public class Crud<T, S> implements Crudable<T, S> {
	
	private Connection conn;

	@Override
	public void insert(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(S id) {
		// TODO Auto-generated method stub
		return null;
	}

}
