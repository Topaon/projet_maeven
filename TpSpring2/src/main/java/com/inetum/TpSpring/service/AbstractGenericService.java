package com.inetum.TpSpring.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.inetum.TpSpring.exception.NotFoundException;

public abstract class AbstractGenericService<E, ID, DTO> implements GenericService<E, ID, DTO> {

	public abstract CrudRepository<E, ID> getDao();
	
	@Override
	public E searchById(ID id) {
		E e = getDao().findById(id).orElse(null);
		if(e!=null) return e;
		else throw new NotFoundException("Entité non trouvé pour l'id : " + id);
	}

	@Override
	public E saveOrUpdate(E entity) {
		return getDao().save(entity);
	}
	
	@Override
	public void deleteById(ID id) {
		getDao().delete(getDao().findById(id).orElse(null));
	}
	
	@Override
	public boolean existById(ID id) {
		return getDao().existsById(id);
	}
	
	@Override
	public List<E> searchAll() {
		return (List<E>) getDao().findAll();
	}
}