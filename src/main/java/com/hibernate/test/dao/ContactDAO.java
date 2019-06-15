package com.hibernate.test.dao;

import java.util.List;
import org.hibernate.Session;
import com.hibernate.test.entity.Contact;
import com.hibernate.test.entity.Person;

public class ContactDAO {
private Session session;
	
	public ContactDAO(Session session) {
		this.session = session;
	}
	
	public Long save(Contact contact) {
		this.session.save(contact);
		return contact.getId();
	}
	
	public void update(Contact contact) {
		this.session.saveOrUpdate(contact);
	}
	
	public void delete(Contact contact) {
		this.session.delete(contact);
	}
	
	public Contact get(Long id) {
		return(Contact) this.session.get(Contact.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> listAll() {
		return (List<Contact>) session.createQuery(
				"FROM Contact c ORDER BY c.phone ASC").list();		
	}
	@SuppressWarnings("unchecked")
	public List<Contact> listAll(String filter) {
		return (List<Contact>) session.createQuery(
				"FROM Contact c WHERE c.phone like (%" +filter+"%) ORDER BY c.phone ASC").list();		
	}
	
}
