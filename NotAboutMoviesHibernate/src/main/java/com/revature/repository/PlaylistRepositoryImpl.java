package com.revature.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Playlist;
import com.revature.util.MySessionFactory;

public class PlaylistRepositoryImpl implements PlaylistRepository{

	public void insertPlaylist(Playlist p) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		
		try {
			
			session = MySessionFactory.getSession();
			transaction = session.beginTransaction();
			session.save(p);
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
