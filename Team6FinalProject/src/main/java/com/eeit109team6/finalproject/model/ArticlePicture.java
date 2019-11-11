package com.eeit109team6.finalproject.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "articlepicture")
public class ArticlePicture {
	
	@Transient
	private MultipartFile newsImage;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pictureId;
	private Blob picture;
	@ManyToOne
	@JoinColumn(name = "NEWSID")
	private News news;

	public ArticlePicture() {
	}

	public Integer getPictureId() {
		return pictureId;
	}

	public void setPictureId(Integer pictureId) {
		this.pictureId = pictureId;
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public MultipartFile getNewsImage() {
		return newsImage;
	}

	public void setNewsImage(MultipartFile newsImage) {
		this.newsImage = newsImage;
	}

}
