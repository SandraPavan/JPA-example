package com.hibernate.test;

import java.util.List;
import org.hibernate.Session;

import com.hibernate.test.dao.ContactDAO;
import com.hibernate.test.dao.PersonDAO;
import com.hibernate.test.entity.Contact;
import com.hibernate.test.entity.Person;

public class HibernateStandAloneDemo {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		PersonDAO daoPerson = new PersonDAO(session);
		ContactDAO daoContact = new ContactDAO(session);
		/*
		Person p1 = daoPerson.get(5l);
		
		Contact c1 = new Contact();
		c1.setPhone("111111");
		c1.setPerson(p1);
		p1.getContacts().add(c1);
		
		daoContact.save(c1);
		*/	
		
		Person p2 = daoPerson.get(2l);
		List<Contact> contacts = p2.getContacts();
		for(Contact contact : contacts) {
			System.out.println("Telefone: " + contact.getPhone());
		}
		
		/*
		List<Person> persons = daoPerson.listAll();
		
		for (Person person2 : persons) {
			System.out.println(person2);		
		*/
		
		session.getTransaction().commit();
		session.close();
	}
}

