package com.eeit109team6.finalproject.service;

import org.springframework.transaction.annotation.Transactional;

import com.eeit109team6.finalproject.model.HomeMovie;

public interface IHomeMovieService {

	HomeMovie findById(Integer id);

}