package com.lrd.entity;

import java.sql.Timestamp;
import java.util.List;

/**
 * AppCategory entity. @author MyEclipse Persistence Tools
 */

public class AppCategory implements java.io.Serializable {

	// Fields

	private Integer id;
	private String categoryCode;
	private String categoryName;
	private Integer parentId;
	private Integer createdBy;
	private Timestamp creationTime;
	private Integer modifyBy;
	private Timestamp modifyDate;
	private AppCategory parentCategory;
	// Constructors

	/** default constructor */
	public AppCategory() {
	}

	/** full constructor */
	public AppCategory(String categoryCode, String categoryName, Integer parentId, Integer createdBy, Timestamp creationTime,
			Integer modifyBy, Timestamp modifyDate) {
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
		this.parentId = parentId;
		this.createdBy = createdBy;
		this.creationTime = creationTime;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryCode() {
		return this.categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
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

	public AppCategory getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(AppCategory parentCategory) {
		this.parentCategory = parentCategory;
	}

}