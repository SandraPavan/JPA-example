package com.hibernate.test.dao;

import java.util.List;
import org.hibernate.Session;

import com.hibernate.test.entity.Contact;
import com.hibernate.test.entity.Person;


public class PersonDAO {
	private Session session;
	
	public PersonDAO(Session session) {
		this.session = session;
	}
	
	public Long save(Person person) {
		this.session.save(person);
		return person.getId();
	}
	
	public void update(Person person) {
		this.session.saveOrUpdate(person);
	}
	
	public void delete(Person person) {
		this.session.delete(person);
	}
	
	public Person get(Long id) {
		return(Person) this.session.get(Person.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> listAll() {
		return (List<Person>) session.createQuery(
				"FROM Person p ORDER BY p.name ASC").list();
				
	}
	@SuppressWarnings("unchecked")
	public List<Person> listAll(String filter) {
		return (List<Person>) session.createQuery(
				"FROM Person p WHERE p.name like (%" +filter+"%) ORDER BY p.name ASC").list();		
	}
	

}
