package com.eeit109team6.finalproject.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BoardType")
public class BoardType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer boardId; // 看板編號
	private String boardName; // 看板名稱
	
	
	//mappedBy="對方變數名稱"
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "boardType", fetch = FetchType.LAZY)
	private Set<Discussion> discussion = new LinkedHashSet<Discussion>();


	public Set<Discussion> getDiscussion() {
		return discussion;
	}

	public void setDiscussion(Set<Discussion> discussion) {
		this.discussion = discussion;
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
