package com.eeit109team6.finalproject.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eeit109team6.finalproject.dao.ILiLoInforDao;
import com.eeit109team6.finalproject.model.LiLoInfo;
import com.eeit109team6.finalproject.model.Member;

@Repository
public class LiLoInforDaoJdbcImpl implements ILiLoInforDao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public LiLoInforDaoJdbcImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Boolean add(LiLoInfo l) {

		sessionFactory.getCurrentSession().save(l);

		return true;

	}

	@Override
	public ArrayList<LiLoInfo> findById(Integer memberId) {
		System.out.println("memberId = " + memberId);
		List<LiLoInfo> imfoList = null;
		Query query = sessionFactory.getCurrentSession().createQuery("from LiLoInfo where memberID = ?1 ");
		query.setParameter(1, memberId);
		imfoList = (ArrayList<LiLoInfo>) query.getResultList();

		return (ArrayList<LiLoInfo>) imfoList;

	}

}
