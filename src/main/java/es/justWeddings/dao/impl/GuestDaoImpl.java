package es.justWeddings.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.justWeddings.dao.GuestDao;
import es.justWeddings.domain.Guest;
@Repository
@Transactional
public class GuestDaoImpl implements GuestDao {
	
	@PersistenceContext
    private EntityManager manager;
	
	@Override
	public void addGuest(Guest guest) {
		manager.persist(guest);
	}

	@Override
	public List<Guest> findAllGuest() {
		// TODO Auto-generated method stub
		return null;
	}

}
