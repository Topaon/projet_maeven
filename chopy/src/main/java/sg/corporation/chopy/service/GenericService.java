package sg.corporation.chopy.service;

import java.util.List;

public interface GenericService<E, ID> {
	
	public List<E>searchAll();
	
	public E searchById(ID id);
	
	public E saveOrUpdate(E entity);
	
	public void removeById (ID id);
}
