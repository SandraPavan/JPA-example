package com.hibernate.test.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.ManyToAny;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue
	private Long id;
	private String phone;
	@ManyToOne
	@JoinColumn(name = "id_person")
	private Person person; 
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
