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
@Table
public class SubjectType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subjectTypeId;//發文分類編號
	private String subjectName;//發文分類名稱
	
	//mappedBy="對方變數名稱"
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "subjectType", fetch = FetchType.LAZY)
	private Set<Discussion> discussion = new LinkedHashSet<Discussion>();

	public Integer getSubjectTypeId() {
		return subjectTypeId;
	}

	public void setSubjectTypeId(Integer subjectTypeId) {
		this.subjectTypeId = subjectTypeId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Set<Discussion> getDiscussion() {
		return discussion;
	}

	public void setDiscussion(Set<Discussion> discussion) {
		this.discussion = discussion;
	}
	
	
}
