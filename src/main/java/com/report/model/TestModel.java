package com.report.model;


public class TestModel {
	
	private String name;
	private String birthDay;
	
	private String sex;
	private String birthPlace;
	
	private String career;
	private String race;
	
	private String nationality;
	private String personId;
	
	private String relationship;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public TestModel(String name, String birthDay, String sex,
			String birthPlace, String career, String race, String nationality,
			String personId, String relationship) {
		super();
		this.name = name;
		this.birthDay = birthDay;
		this.sex = sex;
		this.birthPlace = birthPlace;
		this.career = career;
		this.race = race;
		this.nationality = nationality;
		this.personId = personId;
		this.relationship = relationship;
	}
	
	
	
	

}
