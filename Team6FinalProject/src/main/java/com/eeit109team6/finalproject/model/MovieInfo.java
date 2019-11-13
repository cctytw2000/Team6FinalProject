package com.eeit109team6.finalproject.model;

import java.sql.Blob;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="MovieInfo")
public class MovieInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer movie_ID;
	
	private String name;
	
	private String movie_content;
	@Transient
	private Date date;//Time
	@Transient
	private Integer owner_ID;
	@Transient
	private Integer like_Sum;
	@Transient
	private Integer click_Sum;

	private String location_Test;
	@Transient
	private Blob video;
	
	public Integer getMovie_ID() {
		return movie_ID;
	}
	public void setMovie_ID(Integer movie_ID) {
		this.movie_ID = movie_ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMovie_content() {
		return movie_content;
	}
	public void setMovie_content(String movie_content) {
		this.movie_content = movie_content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getOwner_ID() {
		return owner_ID;
	}
	public void setOwner_ID(Integer owner_ID) {
		this.owner_ID = owner_ID;
	}
	public Integer getLike_Sum() {
		return like_Sum;
	}
	public void setLike_Sum(Integer like_Sum) {
		this.like_Sum = like_Sum;
	}
	public Integer getClick_Sum() {
		return click_Sum;
	}
	public void setClick_Sum(Integer click_Sum) {
		this.click_Sum = click_Sum;
	}
	public String getLocation_Test() {
		return location_Test;
	}
	public void setLocation_Test(String location_Test) {
		this.location_Test = location_Test;
	}
	public Blob getVideo() {
		return video;
	}
	public void setVideo(Blob video) {
		this.video = video;
	}
	
	
}
