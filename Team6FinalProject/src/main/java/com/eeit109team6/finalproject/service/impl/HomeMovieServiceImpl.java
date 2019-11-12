package com.eeit109team6.finalproject.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eeit109team6.finalproject.dao.IHomeMovieDao;
import com.eeit109team6.finalproject.dao.IMemberDao;
import com.eeit109team6.finalproject.model.HomeMovie;
import com.eeit109team6.finalproject.model.Member;
import com.eeit109team6.finalproject.model.MemberLevel;
import com.eeit109team6.finalproject.service.IHomeMovieService;
import com.eeit109team6.finalproject.service.IMemberService;

@Service
public class HomeMovieServiceImpl implements IHomeMovieService {
	IHomeMovieDao dao;

	@Autowired
	public void setDao(IHomeMovieDao dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public HomeMovie findById(Integer id) {

		return dao.findByid(id);
	}

}
