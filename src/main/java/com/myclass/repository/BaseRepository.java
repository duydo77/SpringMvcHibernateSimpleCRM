package com.myclass.repository;

import java.util.List;

public interface BaseRepository<T, K> {

	List<T> findAll();
	
	T findById(K id);

	void save(T entity);

	void delete(K id);
	
}
