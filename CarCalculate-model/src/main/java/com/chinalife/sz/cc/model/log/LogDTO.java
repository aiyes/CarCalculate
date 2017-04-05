package com.chinalife.sz.cc.model.log;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("LogDTO")
public class LogDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1934587554897666211L;
	private String logSerialNo;
	private String serviceNme;
	private String logType;
	private String reqTm;
	private String respTm;
	private String licenseNo;
	private String engineNo;
	private String frameNo;
	private String carOwner;
	private String reqXml;
	private String respXml;
	private String errMsg;
	private Exception exc;
	private String crtUsr;
	
	public String getLogSerialNo() {
		return logSerialNo;
	}
	public void setLogSerialNo(String logSerialNo) {
		this.logSerialNo = logSerialNo;
	}
	public String getServiceNme() {
		return serviceNme;
	}
	public void setServiceNme(String serviceNme) {
		this.serviceNme = serviceNme;
	}
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getReqTm() {
		return reqTm;
	}
	public void setReqTm(String reqTm) {
		this.reqTm = reqTm;
	}
	public String getRespTm() {
		return respTm;
	}
	public void setRespTm(String respTm) {
		this.respTm = respTm;
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
	public String getCarOwner() {
		return carOwner;
	}
	public void setCarOwner(String carOwner) {
		this.carOwner = carOwner;
	}
		
	public String getReqXml() {
		return reqXml;
	}
	public void setReqXml(String reqXml) {
		this.reqXml = reqXml;
	}
	public String getRespXml() {
		return respXml;
	}
	public void setRespXml(String respXml) {
		this.respXml = respXml;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	
	
	public Exception getExc() {
		return exc;
	}
	public void setExc(Exception exc) {
		this.exc = exc;
		this.errMsg = exc==null?null:exc.toString();
	}
	@Override
	public String toString() {
		return "LogDTO [logSerialNo=" + logSerialNo + ", licenseNo=" + licenseNo
				+ ", frameNo=" + frameNo + "]";
	}
	/**
	 * @return the crtUsr
	 */
	public String getCrtUsr() {
		return crtUsr;
	}
	/**
	 * @param crtUsr the crtUsr to set
	 */
	public void setCrtUsr(String crtUsr) {
		this.crtUsr = crtUsr;
	}
	
	
	
}
