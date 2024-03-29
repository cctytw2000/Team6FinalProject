package com.eeit109team6.finalproject.service;

import java.util.ArrayList;

import com.eeit109team6.finalproject.model.Member;
import com.eeit109team6.finalproject.model.MemberLevel;

public interface IMemberService {
	public Integer add(Member m);

	public void update(Member m);

	public void delete(Member m);

	public ArrayList<Member> findAll();

	public Member findById(Member m);

	public Member login(Member m);

	public boolean openActive(Member m);

	public boolean forgetPwd(Member m);

	public Boolean changePwd(Member m);

	public Boolean changePwd(Member m, String oldpassword);

	public boolean checkAccount(Member m);

	public Member checkAccount(String account);

	void openActive(Integer id);

	void closeActive(Integer id);

	void updateLevel(Integer id, MemberLevel level);

}
