package es.justWeddings.beans;

import java.util.function.Predicate;

import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.justWeddings.domain.Guest;
import es.justWeddings.utils.Constants;

@Component
@ViewScoped
public class ResumeBean {

  @Autowired
  private GuestBean guestBean;
  @Autowired
  private GroomsBean groomsBean;

  //TABLE METHODS
  public Long getMenCount(){
	  return guestBean.getGuestList().stream().filter(sexEqueal(Constants.MALE)).count();
  }
  
  public Long getWomensCount(){
	  return guestBean.getGuestList().stream().filter(sexEqueal(Constants.FEMALE)).count();
  }

  public Long getChildsCount(){
	  return guestBean.getGuestList().stream().filter(sexEqueal(Constants.NO)).count();
  }

  public Long getBrideCount(){
	  return guestBean.getGuestList().stream().filter(invitedBy(groomsBean.getBrideName())).count();
  }

  public Long getGroomCount(){
	  return guestBean.getGuestList().stream().filter(invitedBy(groomsBean.getGroomName())).count();
  }

  public Long getGroupCount(String groupName){
	  return guestBean.getGuestList().stream().filter(groupedBy(groupName)).count();
  }

  public Long getAllergicCount(){
	  return guestBean.getGuestList().stream().filter(allergics()).count();
  }

  public Long getVegetarianCount(){
	  return guestBean.getGuestList().stream().filter(vegetarian(Constants.YES)).count();
  }

  public Long getBusNeededCount(){
	  return guestBean.getGuestList().stream().filter(needBus(Constants.YES)).count();
  }

  public Long getInvitationsSendCount(){
	  return guestBean.getGuestList().stream().filter(invitationSend(Constants.YES)).count();
  }

  public Long getConfirmationReceivedCount(){
	  return guestBean.getGuestList().stream().filter(confirmationReceived(Constants.YES)).count();
  }
  
  
  //PREDICATES 
  public Predicate<Guest> sexEqueal(String sex){
	  return (x ->  x.getSex().equals(sex));
  }

  public Predicate<Guest> groupedBy(String groupName){
	  return (x ->  x.getGroup().equals(groupName));
  }

  public Predicate<Guest> invitedBy(String name){
	  return (x ->  x.getInvitedBy().equals(name));
  }

  public Predicate<Guest> allergics(){
	  return (x ->  x.getAllerge() != null && !"".equals(x.getAllerge()));
  }

  public Predicate<Guest> vegetarian(String value){
	  return (x ->  x.getVegetarian().equals(value));
  }

  public Predicate<Guest> needBus(String value){
	  return (x ->  x.getBusRequired().equals(value));
  }

  public Predicate<Guest> invitationSend(String value){
	  return (x ->  x.getInvitationSend().equals(value));
  }
  public Predicate<Guest> confirmationReceived(String value){
	  return (x ->  x.getConfirmationReceived().equals(value));
  }
}