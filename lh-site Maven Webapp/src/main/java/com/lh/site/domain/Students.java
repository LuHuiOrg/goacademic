package com.lh.site.domain;

import java.io.Serializable;

public class Students  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nickName;
	private String password;
	private String mobile;
	private String email;
	private Specialty specialty;
	private Grade grade;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Specialty getSpecialty() {
		return specialty;
	}
	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", nickName=" + nickName + ", password="
				+ password + ", mobile=" + mobile + ", email=" + email
				+ ", specialty=" + specialty + ", grade=" + grade + "]";
	}
	
	

}
