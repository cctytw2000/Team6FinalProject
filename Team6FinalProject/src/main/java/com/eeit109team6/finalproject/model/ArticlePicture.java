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

@Entity
@Table(name="articlepicture")
public class ArticlePicture {

	private Integer pictureId;
	private String pictureName;
	private Blob picture;
	private News news;
	
	public ArticlePicture() {
	}
	
	@Id
	@Column(name="PICTUREID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getPictureId() {
		return pictureId;
	}

	public void setPictureId(Integer pictureId) {
		this.pictureId = pictureId;
	}

	@Column(name="PICTURENAME", columnDefinition = "nvarchar")
	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	@Column(name="PICTURE")
	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	@ManyToOne
	@JoinColumn(name="NEWSID")
	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

}
