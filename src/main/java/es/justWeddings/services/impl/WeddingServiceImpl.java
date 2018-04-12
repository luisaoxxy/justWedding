package es.justWeddings.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.justWeddings.dao.WeddingDao;
import es.justWeddings.domain.Wedding;
import es.justWeddings.services.WeddingService;

@Service
public class WeddingServiceImpl implements WeddingService {

	@Autowired
	private WeddingDao weddingDao;
	
  public Wedding createWedding(Wedding wedding){
	  return weddingDao.create(wedding);
  }

}
