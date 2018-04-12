package es.justWeddings.services.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.justWeddings.dao.GuestDao;
import es.justWeddings.domain.Guest;
import es.justWeddings.domain.User;
import es.justWeddings.services.GuestService;

@Service
public class GuestServiceImpl implements GuestService {

	@Autowired
	private GuestDao guestDao;
	private static final Logger logger = Logger.getLogger(GuestServiceImpl.class.getSimpleName());
	
	@Override
	public List<Guest> getGuests(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String invite(Guest guest) {
		try{
			guest.setUser(new User());
			guest.getUser().setId(1);
			guestDao.addGuest(guest);
		}catch(Exception e){
			logger.log(Level.SEVERE, "Error:", e);
		}
		return null;
	}

	public GuestDao getGuestDao() {
		return guestDao;
	}

	public void setGuestDao(GuestDao guestDao) {
		this.guestDao = guestDao;
	}

}
