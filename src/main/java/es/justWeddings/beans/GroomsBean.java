package es.justWeddings.beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.justWeddings.domain.Wedding;
import es.justWeddings.services.WeddingService;

@Component
@ViewScoped
public class GroomsBean {

	private String brideName;
	private String groomName;
	private Date weddingDate;
	private String weddingPlace;
	private String weddingRestaurant;
	private String weddingType;
	private SimpleDateFormat format;
	
	@Autowired
	private WeddingService weddingService;

	public GroomsBean(){
		brideName="Arantxa";
		groomName="Luis";
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(Calendar.YEAR, 2018);
		cal.set(Calendar.MONTH, 6 );
		cal.set(Calendar.DAY_OF_MONTH, 1);
		weddingDate = cal.getTime();
	}
	
	public String createWedding(){
		Wedding wedding = new Wedding();
		wedding.setBrideName(brideName);
		wedding.setDate(weddingDate);
		wedding.setGroomName(groomName);
		wedding.setPlace(weddingPlace);
		wedding.setRestaurant(weddingRestaurant);
		wedding.setType(weddingType);
		weddingService.createWedding(wedding);
		return "homme";
	}
	
	/* GETTER Y SETTERS */
	public String getBrideName() {
		return brideName;
	}

	public void setBrideName(String brideName) {
		this.brideName = brideName;
	}

	public List<String> getGroomsList() {
		List<String> grooms = new ArrayList<String>();
		grooms.add(brideName);
		grooms.add(groomName);
		return grooms;
	}
	public String getGroomName() {
		return groomName;
	}

	public void setGroomName(String groomName) {
		this.groomName = groomName;
	}

	public Date getWeddingDate() {
		return weddingDate;
	}

	public String getWeddingDateHeader() {
		format = new SimpleDateFormat("dd-MMMM-yyyy");
		return format.format(weddingDate);
	}

	public void setWeddingDate(Date weddingDate) {
		this.weddingDate = weddingDate;
	}

	public String getWeddingPlace() {
		return weddingPlace;
	}

	public void setWeddingPlace(String weddingPlace) {
		this.weddingPlace = weddingPlace;
	}

	public String getWeddingRestaurant() {
		return weddingRestaurant;
	}

	public void setWeddingRestaurant(String weddingRestaurant) {
		this.weddingRestaurant = weddingRestaurant;
	}

	public String getWeddingType() {
		return weddingType;
	}

	public Date getCurrentDate() {
		return new Date();
	}

	public void setWeddingType(String weddingType) {
		this.weddingType = weddingType;
	}

}