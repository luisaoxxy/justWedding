package es.justWeddings.domain;

// Generated 08-Nov-2016 20:05:02 by Hibernate Tools 4.0.0

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "users")
public class Users implements java.io.Serializable {
	@Id
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "NAME")
	private String name;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "SEX")
	private String sex;
	@Column(name = "TELEPHONE")
	private String telephone;
	@Column(name = "ADRESS")
	private String adress;
	@Column(name = "BIRTHDAY")
	private Date birthday;
	@Column(name = "THEME")
	private String theme;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "WEDDING_ID", referencedColumnName = "ID", nullable = false)
	private Wedding wedding = new Wedding();

	public Users() {
	}

	public Users(String name, String lastName, String sex, String email,
			String telephone) {
		this.name = name;
		this.lastName = lastName;
		this.sex = sex;
		this.email = email;
		this.telephone = telephone;
	}

	public Users(String name, String lastName, String sex, String email,
			String telephone, String adress, Date birthday, String theme) {
		this.name = name;
		this.lastName = lastName;
		this.sex = sex;
		this.email = email;
		this.telephone = telephone;
		this.adress = adress;
		this.birthday = birthday;
		this.theme = theme;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Wedding getWedding() {
		return wedding;
	}

	public void setWedding(Wedding wedding) {
		this.wedding = wedding;
	}

}
