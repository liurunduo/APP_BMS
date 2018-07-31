package com.lrd.entity;

import java.sql.Timestamp;

/**
 * AppVersion entity. @author MyEclipse Persistence Tools
 */

public class AppVersion implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer appId;
	private String versionNo;
	private String versionInfo;
	private Integer publishStatus;
	private String downloadLink;
	private Double versionSize;
	private Integer createdBy;
	private Timestamp creationDate;
	private Integer modifyBy;
	private Timestamp modifyDate;
	private String apkLocPath;
	private String apkFileName;
	private String appSoftwareName;
	private String publishStatusName;
	// Constructors

	/** default constructor */
	public AppVersion() {
	}

	public AppVersion(Integer id) {
		super();
		this.id = id;
	}

	
	public AppVersion(Integer id, Integer publishStatus) {
		super();
		this.id = id;
		this.publishStatus = publishStatus;
	}

	public AppVersion(Integer appId, String versionNo, String apkFileName) {
		super();
		this.appId = appId;
		this.versionNo = versionNo;
		this.apkFileName = apkFileName;
	}

	public AppVersion(Integer id, String downloadLink, String apkLocPath, String apkFileName) {
		super();
		this.id = id;
		this.downloadLink = downloadLink;
		this.apkLocPath = apkLocPath;
		this.apkFileName = apkFileName;
	}

	/** full constructor */
	public AppVersion(Integer appId, String versionNo, String versionInfo, Integer publishStatus, String downloadLink,
			Double versionSize, Integer createdBy, Timestamp creationDate, Integer modifyBy, Timestamp modifyDate,
			String apkLocPath, String apkFileName,String appSoftwareName) {
		this.appId = appId;
		this.versionNo = versionNo;
		this.versionInfo = versionInfo;
		this.publishStatus = publishStatus;
		this.downloadLink = downloadLink;
		this.versionSize = versionSize;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.apkLocPath = apkLocPath;
		this.apkFileName = apkFileName;
		this.appSoftwareName=appSoftwareName;
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

	public String getVersionNo() {
		return this.versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public String getVersionInfo() {
		return this.versionInfo;
	}

	public void setVersionInfo(String versionInfo) {
		this.versionInfo = versionInfo;
	}

	public Integer getPublishStatus() {
		return this.publishStatus;
	}

	public void setPublishStatus(Integer publishStatus) {
		this.publishStatus = publishStatus;
	}

	public String getDownloadLink() {
		return this.downloadLink;
	}

	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}

	public Double getVersionSize() {
		return this.versionSize;
	}

	public void setVersionSize(Double versionSize) {
		this.versionSize = versionSize;
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

	public String getApkLocPath() {
		return this.apkLocPath;
	}

	public void setApkLocPath(String apkLocPath) {
		this.apkLocPath = apkLocPath;
	}

	public String getApkFileName() {
		return this.apkFileName;
	}

	public void setApkFileName(String apkFileName) {
		this.apkFileName = apkFileName;
	}

	public String getAppSoftwareName() {
		return appSoftwareName;
	}

	public void setAppSoftwareName(String appSoftwareName) {
		this.appSoftwareName = appSoftwareName;
	}

	public String getPublishStatusName() {
		return publishStatusName;
	}

	public void setPublishStatusName(String publishStatusName) {
		this.publishStatusName = publishStatusName;
	}

}