package com.eeit109team6.finalproject.service;

import java.util.ArrayList;

import com.eeit109team6.finalproject.model.LiLoInfo;

public interface ILiLoInforService {

	public Boolean add(LiLoInfo l);

	ArrayList<LiLoInfo> findById(Integer memberId);



}
