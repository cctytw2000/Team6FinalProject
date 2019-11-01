package com.eeit109team6.finalproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eeit109team6.finalproject.dao.ILiLoInforDao;
import com.eeit109team6.finalproject.dao.IMemberLevelDao;
import com.eeit109team6.finalproject.model.LiLoInfo;
import com.eeit109team6.finalproject.model.MemberLevel;
import com.eeit109team6.finalproject.service.ILiLoInforService;
import com.eeit109team6.finalproject.service.IMemberLevelService;

@Service
public class MemberLevelServiceImpl implements IMemberLevelService {
	IMemberLevelDao dao;

	@Autowired
	public void setDao(IMemberLevelDao dao) {
		this.dao = dao;
	}
	@Transactional
	@Override
	public MemberLevel findById(Integer levelId) {
		// TODO Auto-generated method stub
		return dao.findById(levelId);
	}

//	@Transactional
//	@Override
//	public Boolean add(LiLoInfo l) {
//		// TODO Auto-generated method stub
//		return dao.add(l);
//	}

}
