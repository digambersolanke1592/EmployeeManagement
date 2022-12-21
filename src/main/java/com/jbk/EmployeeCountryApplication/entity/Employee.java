package com.jbk.EmployeeCountryApplication.entity;


import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@Column(unique = true)
	private String email_id;
	
	@Column(unique = true)
	private Long mobile_no;
	private String gender;
	private String department;
	private String status;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime created_date;
	String created_by;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updated_date;
	
	private String updated_by;
	
	@OneToOne(targetEntity = Country.class,cascade=CascadeType.ALL)
	private Country country;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Integer id, String name, String email_id, Long mobile_no, String gender, String department,
			String status, LocalDateTime created_date, String created_by, LocalDateTime updated_date, String updated_by,
			Country country) {
		super();
		this.id = id;
		this.name = name;
		this.email_id = email_id;
		this.mobile_no = mobile_no;
		this.gender = gender;
		this.department = department;
		this.status = status;
		this.created_date = created_date;
		this.created_by = created_by;
		this.updated_date = updated_date;
		this.updated_by = updated_by;
		this.country = country;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public Long getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(Long mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getCreated_date() {
		return created_date;
	}
	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public LocalDateTime getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(LocalDateTime updated_date) {
		this.updated_date = updated_date;
	}
	public String getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email_id=" + email_id + ", mobile_no=" + mobile_no
				+ ", gender=" + gender + ", department=" + department + ", status=" + status + ", created_date="
				+ created_date + ", created_by=" + created_by + ", updated_date=" + updated_date + ", updated_by="
				+ updated_by + ", country=" + country + "]";
	}

	
	

}
