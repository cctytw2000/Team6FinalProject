package com.eeit109team6.finalproject.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eeit109team6.finalproject.dao.IMemberDao;
import com.eeit109team6.finalproject.model.Member;
import com.eeit109team6.finalproject.service.IMemberService;

@Service

public class MemberServiceImpl implements IMemberService {
	IMemberDao dao;

	@Autowired
	public void setDao(IMemberDao dao) {
		this.dao = dao;
	}

	@Override
	public Integer add(Member m) {

		return dao.add(m);
	}

	@Override
	public void update(Member m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Member m) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Member> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member findById(Member m) {

		return dao.findById(m);
	}

	@Override
	public Member login(Member m) {
		// TODO Auto-generated method stub
		return dao.login(m);
	}

	@Override
	public boolean openActive(Member m) {

		return dao.openActive(m);
	}

	@Override
	public boolean forgetPwd(Member m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean changePwd(Member m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean changePwd(Member m, String oldpassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkAccount(Member m) {
		// TODO Auto-generated method stub
		return dao.checkAccount(m);
	}

	@Override
	public Member checkAccount(String account) {
		// TODO Auto-generated method stub
		return dao.checkAccount(account);
	}

}
