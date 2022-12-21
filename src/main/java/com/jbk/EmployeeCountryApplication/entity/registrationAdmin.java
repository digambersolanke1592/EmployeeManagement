package com.jbk.EmployeeCountryApplication.entity;

//import java.util.Date;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class registrationAdmin implements java.io.Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userid;
	private String fname;
	private String lname;
	@Column(unique = true)
	private String email;
	@Column(unique=true)
	private String username;
	@Column(unique=true)
	private String password;
	private String mobileno;
	private String gender;
	private Date createddtm;
	
	public registrationAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public registrationAdmin(Integer userid, String fname, String lname, String email, String username, String password,
			String mobileno, String gender, Date createddtm) {
		super();
		this.userid = userid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.mobileno = mobileno;
		this.gender = gender;
		this.createddtm = createddtm;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCreateddtm() {
		return createddtm;
	}

	public void setCreateddtm(Date createddtm) {
		this.createddtm = createddtm;
	}

	@Override
	public String toString() {
		return "registrationAdmin [userid=" + userid + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", mobileno=" + mobileno + ", gender=" + gender
				+ ", createddtm=" + createddtm + "]";
	}

	
	
	
}