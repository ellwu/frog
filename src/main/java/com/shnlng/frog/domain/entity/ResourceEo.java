package com.shnlng.frog.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "t_resources")
public class ResourceEo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "resource_id")
	private String id;

	@Column(name = "resource_adver_id")
	private String adverId;
	@Transient
	private String adver;

	@Column(name = "resource_type")
	private String type;
	@Transient
	private String typeDesc;

	@Column(name = "resource_origin_name")
	private String originName;
	
	@Column(name = "resource_redirect_url")
	private String redirectUrl;

	@Column(name = "resource_duration")
	private int duration;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "resource_upload_time")
	private Date uploadTime;

	@Column(name = "resource_upload_status")
	private int uploadStatus;

	@Column(name = "resource_category")
	private String category;
	@Transient
	private String categoryDesc;

	@Column(name = "resource_range_age")
	private String rangeAge;

	@Column(name = "resource_range_group")
	private String rangeGroup;

	@Column(name = "resource_target_status")
	private int targetStatus;

	@Column(name = "delete_flag")
	private int deleteFlag;

	@Column(name = "disable_flag")
	private int disableFlag;

	@Column(name = "version")
	private long version;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "creation_time")
	private Date creationTime;

	@Column(name = "created_by")
	private String createdBy;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "update_time")
	private Date updateTime;

	@Column(name = "updated_by")
	private String updatedBy;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdverId() {
		return adverId;
	}

	public void setAdverId(String adverId) {
		this.adverId = adverId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public int getUploadStatus() {
		return uploadStatus;
	}

	public void setUploadStatus(int uploadStatus) {
		this.uploadStatus = uploadStatus;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRangeAge() {
		return rangeAge;
	}

	public void setRangeAge(String rangeAge) {
		this.rangeAge = rangeAge;
	}

	public String getRangeGroup() {
		return rangeGroup;
	}

	public void setRangeGroup(String rangeGroup) {
		this.rangeGroup = rangeGroup;
	}

	public int getTargetStatus() {
		return targetStatus;
	}

	public void setTargetStatus(int targetStatus) {
		this.targetStatus = targetStatus;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public int getDisableFlag() {
		return disableFlag;
	}

	public void setDisableFlag(int disableFlag) {
		this.disableFlag = disableFlag;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	public String getAdver() {
		return adver;
	}

	public void setAdver(String adver) {
		this.adver = adver;
	}

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

}
