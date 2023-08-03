package com.inetum.TpSpring.service;

import org.springframework.data.repository.CrudRepository;

public abstract class AbstractGenericService<E,ID,DTO> implements GenericService<E, ID, DTO> {

	public abstract CrudRepository<E, ID> getDao();
	
	@Override
	public E searchById(ID id) {
		return getDao().findById(id).orElse(null);
	}

	@Override
	public E saveOrUpdate(E entity) {
		return getDao().save(entity);
	}
}