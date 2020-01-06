package com.revature.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Account;
import com.revature.util.MySessionFactory;

public class UserRepositoryImpl implements UserRepository {

	public void insertUser(Account u) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;

		try {

			session = MySessionFactory.getSession();
			transaction = session.beginTransaction();
			session.save(u);
			transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public List<Account> getAllUsers() {
		// TODO Auto-generated method stub
		List<Account> us = null;
		Session session = null;
		Transaction transaction = null;
		
		try {
			
			session = MySessionFactory.getSession();
			transaction = session.beginTransaction();
			us = session.createQuery("from Account").getResultList();
			transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return us;
	}

	public Account getUserByName(String name) {
		// TODO Auto-generated method stub
		Account u = null;
		Session session = null;
		Transaction transaction = null;

		try {

			session = MySessionFactory.getSession();
			transaction = session.beginTransaction();
			u = session.createQuery("from Account where name = :name", Account.class).setParameter("name", name)
					.getSingleResult();
			transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return u;
	}

	public Account getUserById(int id) {
		// TODO Auto-generated method stub
		Account u = null;
		Session session = null;
		Transaction transaction = null;

		try {

			session = MySessionFactory.getSession();
			transaction = session.beginTransaction();
			u = session.createQuery("from Account where id = :id", Account.class).setParameter("id", id).getSingleResult();
			transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return u;
	}

	public void deleteUser(Account u) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		
		try {
			
			session = MySessionFactory.getSession();
			transaction = session.beginTransaction();
			session.delete(u);
			transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
