package assignment6.person.model;

import java.sql.Date;

public class Person {
	
	private int personId;
	private String   personName;
	private int ssn;
	private String driversLicenseNr;
	private Date birthDate;
	private String birthPlace;
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getDriversLicenseNr() {
		return driversLicenseNr;
	}
	public void setDriversLicenseNr(String driversLicenseNr) {
		this.driversLicenseNr = driversLicenseNr;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	
	 
}

