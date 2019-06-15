package com.hibernate.test.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String email;
	
	@OneToMany(mappedBy = "person")
	private List<Contact> contacts;
	
	public List<Contact> getContacts() {
		return contacts;
	}
	
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts = new ArrayList<Contact>();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return name;
	}
	public void setNome(String nome) {
		this.name = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
