package com.eeit109team6.finalproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BoardType")
public class BoardType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer boardId;		//看板編號
	private String boardName;		//看板名稱
	
//	private String boardManager;	//板主，後備功能。有時間再寫
	
	public BoardType() {
		super();
	}

	public BoardType(Integer boardId, String boardName) {
	super();
	this.boardId = boardId;
	this.boardName = boardName;
	}

	public Integer getBoardId() {
		return boardId;
	}

	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

}
