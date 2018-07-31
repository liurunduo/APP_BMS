package com.lrd.entity;

import java.sql.Timestamp;

/**
 * BackendUser entity. @author MyEclipse Persistence Tools
 */

public class BackendUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userCode;
	private String userName;
	private Integer userType;
	private Integer createdBy;
	private String userTypeName;
	private Timestamp creationDate;
	private Integer modifyBy;
	private Timestamp modifyDate;
	private String userPassword;

	// Constructors

	/** default constructor */
	public BackendUser() {
	}

	/** full constructor */
	public BackendUser(Integer id, String userCode, String userName, Integer userType, Integer createdBy,
			String userTypeName, Timestamp creationDate, Integer modifyBy, Timestamp modifyDate, String userPassword) {
		super();
		this.id = id;
		this.userCode = userCode;
		this.userName = userName;
		this.userType = userType;
		this.createdBy = createdBy;
		this.userTypeName = userTypeName;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.userPassword = userPassword;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserType() {
		return this.userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getModifyBy() {
		return this.modifyBy;
	}

	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Timestamp getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

}