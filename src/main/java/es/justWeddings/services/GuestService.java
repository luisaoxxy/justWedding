package es.justWeddings.services;

import java.util.List;

import es.justWeddings.domain.Guest;

public interface GuestService {

  public List<Guest> getGuests(String userId);

  public String invite(Guest guest);

}
