package com.chinalife.sz.cc.domain;

import java.io.Serializable;

/**
 * 车辆保单数据查询接口请求信息
 *
 * @author MarsCheng
 */

public class CarPolicyRequest  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1687765070822959839L;
	
	//请求类型 Y
	private String requestType;
	//操作员 N
	private String operator;
	//号牌号码 N
	private String licenseNo;
	//发动机号 N
	private String engineNo;
	//车架号 N
	private String frameNo;

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getFrameNo() {
		return frameNo;
	}

	public void setFrameNo(String frameNo) {
		this.frameNo = frameNo;
	}

	@Override
	public String toString() {
		return "CarPolicyRequest [RequestType=" + requestType + ",Operator=" + operator + ",LicenseNo=" + licenseNo + ",EngineNo=" + engineNo + ",FrameNo=" + frameNo + "] ";
	}


}
