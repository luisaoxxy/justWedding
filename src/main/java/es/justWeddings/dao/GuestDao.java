package es.justWeddings.dao;

import java.util.List;

import es.justWeddings.domain.Guest;

public interface GuestDao{

	public void addGuest(Guest guest);

	public List<Guest> findAllGuest();
}