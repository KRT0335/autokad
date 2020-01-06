package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Session Factory
public class MySessionFactory {

	private static SessionFactory sessionFactory;

	public static Session getSession() {

		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure()
					.setProperty("hibernate.connection.url", System.getenv("DBURL"))
					.setProperty("hibernate.connection.username", System.getenv("DBUsername"))
					.setProperty("hibernate.connection.password", System.getenv("DBPassword"))
					.buildSessionFactory();

		}
		return sessionFactory.getCurrentSession();
	}

}
