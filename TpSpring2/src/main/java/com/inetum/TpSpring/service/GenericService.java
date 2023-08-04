package com.inetum.TpSpring.service;

import java.util.List;

public interface GenericService<E, ID, DTO> {
	public E searchById(ID id);
	public E saveOrUpdate(E entity);
	void deleteById(ID id);
	boolean existById(ID id);
	List<E> searchAll();
}