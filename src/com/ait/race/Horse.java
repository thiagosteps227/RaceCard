package com.ait.race;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Horse {

    private int id;
    
    private int age;

    private String name;

    private String trainer;

    private String jockey;

    private String owner;
    
    private String breeder;
    
    private String picture;

    private String sire;
    
    private String dam;
    
    private String betting;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	
	public String getJockey() {
		return jockey;
	}

	public void setJockey(String jockey) {
		this.jockey = jockey;
	}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getBreeder() {
		return breeder;
	}

	public void setBreeder(String breeder) {
		this.breeder = breeder;
	}

	public String getSire() {
		return sire;
	}

	public void setSire(String sire) {
		this.sire = sire;
	}

	public String getDam() {
		return dam;
	}

	public void setBetting(String betting) {
		this.betting = betting;
	}
	
	public String getBetting() {
		return betting;
	}

	public void setDam(String dam) {
		this.dam = dam;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
}


