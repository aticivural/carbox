package com.carbox.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS_CARBOX")
public class User implements Serializable {
	

	private static final long serialVersionUID = -3544060262401999719L;

	private int userId;
	private String name;
	private String surname;
	private String mail;
	private String password;
	
	public User() {}

	public User(String name, String surname, String mail, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.password = password;
	}
	
	@Id
    @Column(name = "USER_ID", unique = true, nullable = false, length=5)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column(name = "USER_NAME", nullable = false, length = 20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "USER_SURNAME", nullable = false, length = 20)
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Column(name = "USER_MAIL", nullable = false, length = 20)
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Column(name = "USER_PASSWORD", nullable = false, length = 20)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name
				+ ", surname=" + surname + ", mail=" + mail + ", password="
				+ password + "]";
	}
	
}
