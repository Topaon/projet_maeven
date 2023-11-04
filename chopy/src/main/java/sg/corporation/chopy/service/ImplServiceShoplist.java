package sg.corporation.chopy.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import sg.corporation.chopy.dao.DaoShoplist;
import sg.corporation.chopy.entity.Shoplist;

@Service
@Transactional
public class ImplServiceShoplist extends AbstractGenericService<Shoplist, Long> implements ServiceShoplist {

	@Autowired
	DaoShoplist daoShoplist;
	
	@Override
	public CrudRepository<Shoplist, Long> getDao() {
		return daoShoplist;
	}

}
