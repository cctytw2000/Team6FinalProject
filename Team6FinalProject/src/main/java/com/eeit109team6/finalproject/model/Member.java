package com.eeit109team6.finalproject.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

// Test from DavidChen-TP
// kunalin asdasd
// Doris
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Test From Git Third
//andy is a handsome boy.
//test git abc
@Component(value = "member")
@Scope(value = "prototype")
@Entity
@Table(name = "member")
public class Member {
	private int member_id;
	private String account;
	private String password;
	private String registeredtime;
	private String token;
	private String username;

	private String type;
	private int isactive;
	private MemberDetail memberdetail;

	private MemberLevel memberlevel;
	private Set<LiLoInfo> liLoInfo = new  LinkedHashSet<LiLoInfo>();


	private Set<Orders> orders = new LinkedHashSet<Orders>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="MEMBERLEVEL" )
	public MemberLevel getMemberlevel() {
		return memberlevel;
	}

	public void setMemberlevel(MemberLevel memberlevel) {
		this.memberlevel = memberlevel;
	}
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "member", fetch = FetchType.EAGER)
	public Set<Orders> getOrders() {
		return orders;
	}


	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "member", fetch = FetchType.EAGER)
	public Set<LiLoInfo> getLiLoInfo() {
		return liLoInfo;
	}

	public void setLiLoInfo(Set<LiLoInfo> liLoInfo) {
		this.liLoInfo = liLoInfo;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "member", cascade = CascadeType.ALL)
	public MemberDetail getMemberdetail() {
		return memberdetail;
	}

	public void setMemberdetail(MemberDetail memberdetail) {
		this.memberdetail = memberdetail;
	}

	

	
	
	
	
	
	
	


	@Column(name = "ACCOUNT")
	public String getAccount() {
		return account;
	}

	@Column(name = "USERNAME")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "REGISTEREDTIME")
	public String getRegisteredtime() {
		return registeredtime;
	}

	public void setRegisteredtime(String registeredtime) {
		this.registeredtime = registeredtime;
	}

	@Id
	@Column(name = "MEMBER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	@Column(name = "ISACTIVE")
	public int getIsactive() {
		return isactive;
	}

	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}

	@Column(name = "TOKEN")
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Column(name = "TYPE")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



}
