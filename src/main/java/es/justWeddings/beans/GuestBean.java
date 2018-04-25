package es.justWeddings.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.justWeddings.domain.Guest;
import es.justWeddings.services.GuestService;
import es.justWeddings.utils.Constants;

@Component
@ViewScoped
public class GuestBean {

  @Autowired
  private GuestService guestService;
  @Autowired
  private ThemeSwitcherBean themeSwitcherBean;

  private String guestName;
  private String guestLastName;
  private String guestSex;
  private String allergy;
  private String group;
  private String invitedBy;
  private Integer tableId;
  private boolean invitationSend;
  private boolean confirmationReceived;
  private boolean haveAllergies;
  private boolean vegetarian;
  private boolean busRequired;
  private Guest editGuest;
  
  private List<String> guestGroups;
  private List<Guest> guestList;

  /**
   * init guestList
   */
  public void init() {
    guestList = guestService.getGuests("");
    if(guestList == null){
    	guestList = new ArrayList<Guest>();
    	Guest guest = new Guest("Manu", "Torres", "M");
    	guest.setVegetarian("N");
    	guest.setBusRequired("Y");
    	guest.setInvitedBy("Luis");
    	guest.setGroup("Marmotas");
    	guest.setInvitationSend(Constants.YES);
    	guestList.add(guest);
    	guest = new Guest("Natalia", "Peque", "F");
    	guest.setVegetarian("Y");
    	guest.setBusRequired("Y");
    	guest.setInvitedBy("Arantxa");
    	guest.setGroup("Uni");
    	guest.setAllerge("Lactosa");
    	guest.setInvitationSend(Constants.YES);
    	guest.setConfirmationReceived(Constants.YES);
    	guestList.add(guest);
    }

  }

  /**
   * add guest to guestList
   */
  public String invite() {
    Guest newGuest = new Guest(guestName, guestLastName,guestSex);
    newGuest.setAllerge(allergy);
    newGuest.setGroup(group);
    newGuest.setInvitedBy(invitedBy);
    newGuest.setConfirmationReceived(confirmationReceived ? Constants.YES : Constants.NO);
    newGuest.setInvitationSend(invitationSend ? Constants.YES : Constants.NO);
    newGuest.setVegetarian(vegetarian ? Constants.YES : Constants.NO);
    newGuest.setBusRequired(busRequired ? Constants.YES : Constants.NO);
    guestService.invite(newGuest);
    guestList.add(newGuest);
    return "guestList";
  }

  public String updateInfo() {
	  editGuest.setName(guestName);
	  editGuest.setLastName(guestLastName);
	  editGuest.setSex(guestSex);
	  editGuest.setAllerge(allergy);
	  editGuest.setGroup(group);
	  editGuest.setInvitedBy(invitedBy);
	  editGuest.setConfirmationReceived(confirmationReceived ? Constants.YES : Constants.NO);
	  editGuest.setInvitationSend(invitationSend ? Constants.YES : Constants.NO);
	  editGuest.setVegetarian(vegetarian ? Constants.YES : Constants.NO);
	  editGuest.setBusRequired(busRequired ? Constants.YES : Constants.NO);
	  return "";
  }

  /* GETTER Y SETTERS */
  public void setGuestService(GuestService guestService) {
    this.guestService = guestService;
  }

  public int getSize(){
	  return guestList != null ? guestList.size() :0;
  }
  public String getGuestName() {
    return guestName;
  }

  public void setGuestName(String guestName) {
    this.guestName = guestName;
  }

  public String getGuestLastName() {
    return guestLastName;
  }

  public void setGuestLastName(String guestLastName) {
    this.guestLastName = guestLastName;
  }

  public List<Guest> getGuestList() {
    return guestList;
  }

  public void setGuestList(List<Guest> guestList) {
    this.guestList = guestList;
  }

public ThemeSwitcherBean getThemeSwitcherBean() {
	return themeSwitcherBean;
}

public void setThemeSwitcherBean(ThemeSwitcherBean themeSwitcherBean) {
	this.themeSwitcherBean = themeSwitcherBean;
}

public GuestService getGuestService() {
	return guestService;
}

public String getGuestSex() {
	return guestSex;
}

public void setGuestSex(String guestSex) {
	this.guestSex = guestSex;
}

public String getInvitedBy() {
	return invitedBy;
}

public void setInvitedBy(String invitedBy) {
	this.invitedBy = invitedBy;
}

public String getGroup() {
	return group;
}

public void setGroup(String group) {
	this.group = group;
}

public List<String> getGuestGroups() {
	if(guestGroups == null){
		guestGroups = new ArrayList<String>();
		for (Guest guest : guestList) {
			if(guest.getGroup() != null && !guestGroups.contains(guest.getGroup())){
				guestGroups.add(guest.getGroup());
			}
		}
	}
	return guestGroups;
}

public void setGuestGroups(List<String> guestGroups) {
	this.guestGroups = guestGroups;
}

public boolean isHaveAllergies() {
	return haveAllergies;
}

public void setHaveAllergies(boolean haveAllergies) {
	this.haveAllergies = haveAllergies;
}

public void setInvitationSend(boolean invitationSend) {
	this.invitationSend = invitationSend;
}

public void setConfirmationReceived(boolean confirmationReceived) {
	this.confirmationReceived = confirmationReceived;
}

public boolean isInvitationSend() {
	return invitationSend;
}

public boolean isConfirmationReceived() {
	return confirmationReceived;
}

public boolean isBusRequired() {
	return busRequired;
}

public void setBusRequired(boolean busRequired) {
	this.busRequired = busRequired;
}

public boolean isVegetarian() {
	return vegetarian;
}

public void setVegetarian(boolean vegetarian) {
	this.vegetarian = vegetarian;
}

public String getAllergy() {
	return allergy;
}

public void setAllergy(String allergy) {
	this.allergy = allergy;
}

public Integer getTableId() {
	return tableId;
}

public void setTableId(Integer tableId) {
	this.tableId = tableId;
}

public Guest getEditGuest() {
	return editGuest;
}

public void setEditGuest(Guest editGuest) {
	this.editGuest = editGuest;
	if(editGuest == null){
		editGuest = new Guest();
	}
	guestName = editGuest.getName();
	guestLastName = editGuest.getLastName();
	guestSex = editGuest.getSex();
	allergy = editGuest.getAllerge();
    group = editGuest.getGroup();
    invitedBy = editGuest.getInvitedBy();
    confirmationReceived = Constants.YES.equals(editGuest.getConfirmationReceived());
    invitationSend = Constants.YES.equals(editGuest.getInvitationSend());
    vegetarian = Constants.YES.equals(editGuest.getVegetarian());
    busRequired = Constants.YES.equals(editGuest.getBusRequired());
}

}
