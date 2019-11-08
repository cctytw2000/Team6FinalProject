package com.eeit109team6.finalproject.model;

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
	@Transient
	private String movie_content;
	@Transient
	private Date time;
	
	private Integer owner_ID;
	@Transient
	private Integer like_Sum;
	@Transient
	private Integer click_Sum;
	
	
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
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
	
}
