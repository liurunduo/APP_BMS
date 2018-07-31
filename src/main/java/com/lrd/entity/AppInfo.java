package com.lrd.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AppInfo entity. @author MyEclipse Persistence Tools
 */

public class AppInfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String softwareName;
	private String apkname;
	private String supportRom;
	private String interfaceLanguage;
	private Double softwareSize;
	private Date updateDate;
	private Integer devId;
	private String appInfo;
	private Integer status;
	private Timestamp onSaleDate;
	private Timestamp offSaleDate;
	private Integer flatformId;
	private Integer categoryLevel3;
	private Integer downloads;
	private Integer createdBy;
	private Timestamp creationDate;
	private Integer modifyBy;
	private Timestamp modifyDate;
	private Integer categoryLevel1;
	private Integer categoryLevel2;
	private String logoPicPath;
	private String logoLocPath;
	private Integer versionId;
	private String flatformName;
	private String categoryLevel1Name;
	private String categoryLevel2Name;
	private String categoryLevel3Name;
	private String statusName;
	private String versionNo;
	public AppInfo() {
	}
	public AppInfo(String apkname,Integer devId,Integer id) {
		super();
		this.apkname = apkname;
		this.devId=devId;
		this.id=id;
	}
	
	public AppInfo(String logoPicPath, String logoLocPath,Integer id) {
		super();
		this.logoPicPath = logoPicPath;
		this.logoLocPath = logoLocPath;
		this.id=id;
	}
	public AppInfo(Integer id, Integer versionId) {
		super();
		this.id = id;
		this.versionId = versionId;
	}
	
	public AppInfo(Integer id, String softwareName, String apkname, String supportRom, String interfaceLanguage,
			Double softwareSize, Date updateDate, Integer devId, String appInfo, Integer status, Timestamp onSaleDate,
			Timestamp offSaleDate, Integer flatformId, Integer categoryLevel3, Integer downloads, Integer createdBy,
			Timestamp creationDate, Integer modifyBy, Timestamp modifyDate, Integer categoryLevel1,
			Integer categoryLevel2, String logoPicPath, String logoLocPath, Integer versionId, String flatformName,
			String categoryLevel1Name, String categoryLevel2Name, String categoryLevel3Name, String statusName,
			String versionNo) {
		super();
		this.id = id;
		this.softwareName = softwareName;
		this.apkname = apkname;
		this.supportRom = supportRom;
		this.interfaceLanguage = interfaceLanguage;
		this.softwareSize = softwareSize;
		this.updateDate = updateDate;
		this.devId = devId;
		this.appInfo = appInfo;
		this.status = status;
		this.onSaleDate = onSaleDate;
		this.offSaleDate = offSaleDate;
		this.flatformId = flatformId;
		this.categoryLevel3 = categoryLevel3;
		this.downloads = downloads;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.categoryLevel1 = categoryLevel1;
		this.categoryLevel2 = categoryLevel2;
		this.logoPicPath = logoPicPath;
		this.logoLocPath = logoLocPath;
		this.versionId = versionId;
		this.flatformName = flatformName;
		this.categoryLevel1Name = categoryLevel1Name;
		this.categoryLevel2Name = categoryLevel2Name;
		this.categoryLevel3Name = categoryLevel3Name;
		this.statusName = statusName;
		this.versionNo = versionNo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSoftwareName() {
		return softwareName;
	}
	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}
	public String getApkname() {
		return apkname;
	}
	public void setApkname(String apkname) {
		this.apkname = apkname;
	}
	public String getSupportRom() {
		return supportRom;
	}
	public void setSupportRom(String supportRom) {
		this.supportRom = supportRom;
	}
	public String getInterfaceLanguage() {
		return interfaceLanguage;
	}
	public void setInterfaceLanguage(String interfaceLanguage) {
		this.interfaceLanguage = interfaceLanguage;
	}
	public Double getSoftwareSize() {
		return softwareSize;
	}
	public void setSoftwareSize(Double softwareSize) {
		this.softwareSize = softwareSize;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Integer getDevId() {
		return devId;
	}
	public void setDevId(Integer devId) {
		this.devId = devId;
	}
	public String getAppInfo() {
		return appInfo;
	}
	public void setAppInfo(String appInfo) {
		this.appInfo = appInfo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Timestamp getOnSaleDate() {
		return onSaleDate;
	}
	public void setOnSaleDate(Timestamp onSaleDate) {
		this.onSaleDate = onSaleDate;
	}
	public Timestamp getOffSaleDate() {
		return offSaleDate;
	}
	public void setOffSaleDate(Timestamp offSaleDate) {
		this.offSaleDate = offSaleDate;
	}
	public Integer getFlatformId() {
		return flatformId;
	}
	public void setFlatformId(Integer flatformId) {
		this.flatformId = flatformId;
	}
	public Integer getCategoryLevel3() {
		return categoryLevel3;
	}
	public void setCategoryLevel3(Integer categoryLevel3) {
		this.categoryLevel3 = categoryLevel3;
	}
	public Integer getDownloads() {
		return downloads;
	}
	public void setDownloads(Integer downloads) {
		this.downloads = downloads;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Timestamp getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Integer getCategoryLevel1() {
		return categoryLevel1;
	}
	public void setCategoryLevel1(Integer categoryLevel1) {
		this.categoryLevel1 = categoryLevel1;
	}
	public Integer getCategoryLevel2() {
		return categoryLevel2;
	}
	public void setCategoryLevel2(Integer categoryLevel2) {
		this.categoryLevel2 = categoryLevel2;
	}
	public String getLogoPicPath() {
		return logoPicPath;
	}
	public void setLogoPicPath(String logoPicPath) {
		this.logoPicPath = logoPicPath;
	}
	public String getLogoLocPath() {
		return logoLocPath;
	}
	public void setLogoLocPath(String logoLocPath) {
		this.logoLocPath = logoLocPath;
	}
	public Integer getVersionId() {
		return versionId;
	}
	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}
	public String getFlatformName() {
		return flatformName;
	}
	public void setFlatformName(String flatformName) {
		this.flatformName = flatformName;
	}
	public String getCategoryLevel1Name() {
		return categoryLevel1Name;
	}
	public void setCategoryLevel1Name(String categoryLevel1Name) {
		this.categoryLevel1Name = categoryLevel1Name;
	}
	public String getCategoryLevel2Name() {
		return categoryLevel2Name;
	}
	public void setCategoryLevel2Name(String categoryLevel2Name) {
		this.categoryLevel2Name = categoryLevel2Name;
	}
	public String getCategoryLevel3Name() {
		return categoryLevel3Name;
	}
	public void setCategoryLevel3Name(String categoryLevel3Name) {
		this.categoryLevel3Name = categoryLevel3Name;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}
}