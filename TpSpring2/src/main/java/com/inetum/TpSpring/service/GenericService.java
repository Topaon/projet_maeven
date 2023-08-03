package com.inetum.TpSpring.service;

public interface GenericService<E,ID,DTO> {
	public E searchById(ID id);
	// public DTO searchById(ID id);
	public E saveOrUpdate(E entity);
}