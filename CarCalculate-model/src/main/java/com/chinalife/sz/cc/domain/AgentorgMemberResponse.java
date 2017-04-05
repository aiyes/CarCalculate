package com.chinalife.sz.cc.domain;

import java.io.Serializable;

/**
 * 中介跟单销售信息
 * @author MarsCheng
 *
 */

public class AgentorgMemberResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1043975732172927524L;
	
	private String VocationId;
	private String PsnCode;
	private String PsnName;
	private String PsnPhoneNumber;
	public String getVocationId() {
		return VocationId;
	}
	public void setVocationId(String vocationId) {
		VocationId = vocationId;
	}
	public String getPsnCode() {
		return PsnCode;
	}
	public void setPsnCode(String psnCode) {
		PsnCode = psnCode;
	}
	public String getPsnName() {
		return PsnName;
	}
	public void setPsnName(String psnName) {
		PsnName = psnName;
	}
	public String getPsnPhoneNumber() {
		return PsnPhoneNumber;
	}
	public void setPsnPhoneNumber(String psnPhoneNumber) {
		PsnPhoneNumber = psnPhoneNumber;
	}
	
	


}
