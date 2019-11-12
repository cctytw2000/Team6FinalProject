package com.eeit109team6.finalproject.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.eeit109team6.finalproject.model.HomeMovie;

public interface IHomeMovieDao {

	void setSession(SessionFactory factory);

	HomeMovie findByid(Integer id);



}