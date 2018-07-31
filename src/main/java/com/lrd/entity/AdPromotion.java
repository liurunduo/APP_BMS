package com.lrd.entity;

import java.sql.Timestamp;

/**
 * AdPromotion entity. @author MyEclipse Persistence Tools
 */

public class AdPromotion implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer appId;
	private String adPicPath;
	private Integer adPv;
	private Integer carouselPosition;
	private Timestamp startTime;
	private Timestamp endTime;
	private Integer createdBy;
	private Timestamp creationDate;
	private Integer modifyBy;
	private Timestamp modifyDate;

	// Constructors

	/** default constructor */
	public AdPromotion() {
	}

	/** full constructor */
	public AdPromotion(Integer appId, String adPicPath, Integer adPv, Integer carouselPosition, Timestamp startTime,
			Timestamp endTime, Integer createdBy, Timestamp creationDate, Integer modifyBy, Timestamp modifyDate) {
		this.appId = appId;
		this.adPicPath = adPicPath;
		this.adPv = adPv;
		this.carouselPosition = carouselPosition;
		this.startTime = startTime;
		this.endTime = endTime;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
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

	public Integer getAppId() {
		return this.appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public String getAdPicPath() {
		return this.adPicPath;
	}

	public void setAdPicPath(String adPicPath) {
		this.adPicPath = adPicPath;
	}

	public Integer getAdPv() {
		return this.adPv;
	}

	public void setAdPv(Integer adPv) {
		this.adPv = adPv;
	}

	public Integer getCarouselPosition() {
		return this.carouselPosition;
	}

	public void setCarouselPosition(Integer carouselPosition) {
		this.carouselPosition = carouselPosition;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
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

}