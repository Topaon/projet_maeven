package sg.corporation.chopy.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public abstract class AbstractGenericService<E, ID> implements GenericService<E, ID> {
	
	public abstract CrudRepository<E, ID> getDao();
	
	@Override
	public List<E> searchAll() {
		return (List<E>) getDao().findAll();
	}
	
	@Override
	public E searchById(ID id) {
		E e = getDao().findById(id).orElse(null);
		return e;
	}

	@Override
	public E saveOrUpdate(E entity) {
		return getDao().save(entity);
	}

	@Override
	public void removeById(ID id) {
		getDao().deleteById(id);
	}
}
