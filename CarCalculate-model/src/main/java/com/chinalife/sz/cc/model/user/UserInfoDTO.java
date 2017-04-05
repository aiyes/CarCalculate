package com.chinalife.sz.cc.model.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("UserInfoDTO")
public class UserInfoDTO implements Serializable {
	/**
	 * 用户表
	 */
	private static final long serialVersionUID = -8351727269014839327L;
	
	private String userCde;
	private String userNme;
	private String userStatus;
	private String password;
	//分公司代码
	private String comcode;
	//分公司名称
	private String comcodeNme;
	//可管理的销售渠道范围（分公司业管用户字段）
	private String channelTypeList;
	private String dept;
	private String deptNme;
	private String handler1Cde;
	private String handler1Nme;
	private String handlerCde;
	private String handlerNme;
	private String channelType;
	private String channelName;
	private String businessNatureCde;
	private String businessNatureNme;
	private String agentCde;
	private String agentNme;
	private String permitNo;
	private String agreementNo;
	//默认车牌号码首位
	private String licenseNo;
	//默认车辆归属地代码
	private String ownershipNo;
	private String remark;
	private String field1;
	private String field2;
	private String field3;
	//用户角色
	private String roleCode;
	//角色名称
	private String roleName;
	//用户权限
	private String modelCode;
	private String crtMan;
	private String crtTime;
	private String updTime;
	private Date crtTM;
	private Date updTM;
	private String updMan;
	

	public String getUserCde() {
		return userCde;
	}
	public void setUserCde(String userCde) {
		this.userCde = userCde;
	}
	public String getUserNme() {
		return userNme;
	}
	public void setUserNme(String userNme) {
		this.userNme = userNme;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDeptNme() {
		return deptNme;
	}
	public void setDeptNme(String deptNme) {
		this.deptNme = deptNme;
	}
	public String getHandlerCde() {
		return handlerCde;
	}
	public void setHandlerCde(String handlerCde) {
		this.handlerCde = handlerCde;
	}
	public String getHandlerNme() {
		return handlerNme;
	}
	public void setHandlerNme(String handlerNme) {
		this.handlerNme = handlerNme;
	}
	public String getBusinessNatureCde() {
		return businessNatureCde;
	}
	public void setBusinessNatureCde(String businessNatureCde) {
		this.businessNatureCde = businessNatureCde;
	}
	public String getAgentCde() {
		return agentCde;
	}
	public void setAgentCde(String agentCde) {
		this.agentCde = agentCde;
	}
	public String getAgentNme() {
		return agentNme;
	}
	public void setAgentNme(String agentNme) {
		this.agentNme = agentNme;
	}
	public String getPermitNo() {
		return permitNo;
	}
	public void setPermitNo(String permitNo) {
		this.permitNo = permitNo;
	}
	public String getAgreementNo() {
		return agreementNo;
	}
	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
	}
	public String getCrtMan() {
		return crtMan;
	}
	public void setCrtMan(String crtMan) {
		this.crtMan = crtMan;
	}
	public String getUpdMan() {
		return updMan;
	}
	public void setUpdMan(String updMan) {
		this.updMan = updMan;
	}
	
	
	
	public Date getCrtTM() {
		return crtTM;
	}
	public void setCrtTM(Date crtTM) {
		this.crtTM = crtTM;
	}
	public Date getUpdTM() {
		return updTM;
	}
	public void setUpdTM(Date updTM) {
		this.updTM = updTM;
	}
	public String getCrtTime() {
		return crtTime;
	}
	public void setCrtTime(String crtTime) {
		this.crtTime = crtTime;
	}
	public String getUpdTime() {
		return updTime;
	}
	public void setUpdTime(String updTime) {
		this.updTime = updTime;
	}
	public String getHandler1Cde() {
		return handler1Cde;
	}
	public void setHandler1Cde(String handler1Cde) {
		this.handler1Cde = handler1Cde;
	}
	public String getHandler1Nme() {
		return handler1Nme;
	}
	public void setHandler1Nme(String handler1Nme) {
		this.handler1Nme = handler1Nme;
	}
	public String getChannelType() {
		return channelType;
	}
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public String getField2() {
		return field2;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	public String getField3() {
		return field3;
	}
	public void setField3(String field3) {
		this.field3 = field3;
	}
	/**
	 * @return the businessNatureNme
	 */
	public String getBusinessNatureNme() {
		return businessNatureNme;
	}
	/**
	 * @param businessNatureNme the businessNatureNme to set
	 */
	public void setBusinessNatureNme(String businessNatureNme) {
		this.businessNatureNme = businessNatureNme;
	}
	/**
	 * @return the channelName
	 */
	public String getChannelName() {
		return channelName;
	}
	/**
	 * @param channelName the channelName to set
	 */
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getComcode() {
		return comcode;
	}
	public void setComcode(String comcode) {
		this.comcode = comcode;
	}
	
	public String getComcodeNme() {
		return comcodeNme;
	}
	public void setComcodeNme(String comcodeNme) {
		this.comcodeNme = comcodeNme;
	}
	public String getChannelTypeList() {
		return channelTypeList;
	}
	public void setChannelTypeList(String channelTypeList) {
		this.channelTypeList = channelTypeList;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getOwnershipNo() {
		return ownershipNo;
	}
	public void setOwnershipNo(String ownershipNo) {
		this.ownershipNo = ownershipNo;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getModelCode() {
		return modelCode;
	}
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}
	
	
	
	
}
