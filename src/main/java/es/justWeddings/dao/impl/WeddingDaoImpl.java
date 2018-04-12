package es.justWeddings.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.justWeddings.dao.WeddingDao;
import es.justWeddings.domain.Wedding;

@Repository
@Transactional
public class WeddingDaoImpl implements WeddingDao {
	
	@PersistenceContext
    private EntityManager manager;
	
	@Override
	public Wedding create(Wedding wedding) {
		manager.persist(wedding);
		return wedding;
	}

}