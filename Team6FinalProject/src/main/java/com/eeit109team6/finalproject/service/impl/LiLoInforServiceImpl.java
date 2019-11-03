package com.eeit109team6.finalproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eeit109team6.finalproject.dao.ILiLoInforDao;
import com.eeit109team6.finalproject.model.LiLoInfo;
import com.eeit109team6.finalproject.service.ILiLoInforService;

@Service
public class LiLoInforServiceImpl implements ILiLoInforService {
	ILiLoInforDao dao;

	@Autowired
	public void setDao(ILiLoInforDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public Boolean add(LiLoInfo l) {
		// TODO Auto-generated method stub
		return dao.add(l);
	}

}
