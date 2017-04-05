package com.chinalife.sz.cc.domain;

import java.io.Serializable;

/**
 * 指定驾驶员列表
 * @author xinxi4
 *
 */

public class CarDriverDataResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7251761017139697516L;
	private String DriverName;
	private String IdentifyNumber;
	private String Sex;
	private String Age;
	private String Marriage;
	private String DrivingCarType;
	private String AcceptLicenseDate;
	private String DrivingYears;
	private String LicenseStatus;
	private String DrivingLicenseType;
	private String CarDriverFlag;
	public String getDriverName() {
		return DriverName;
	}
	public void setDriverName(String driverName) {
		DriverName = driverName;
	}
	public String getIdentifyNumber() {
		return IdentifyNumber;
	}
	public void setIdentifyNumber(String identifyNumber) {
		IdentifyNumber = identifyNumber;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getMarriage() {
		return Marriage;
	}
	public void setMarriage(String marriage) {
		Marriage = marriage;
	}
	public String getDrivingCarType() {
		return DrivingCarType;
	}
	public void setDrivingCarType(String drivingCarType) {
		DrivingCarType = drivingCarType;
	}
	public String getAcceptLicenseDate() {
		return AcceptLicenseDate;
	}
	public void setAcceptLicenseDate(String acceptLicenseDate) {
		AcceptLicenseDate = acceptLicenseDate;
	}
	public String getDrivingYears() {
		return DrivingYears;
	}
	public void setDrivingYears(String drivingYears) {
		DrivingYears = drivingYears;
	}
	public String getLicenseStatus() {
		return LicenseStatus;
	}
	public void setLicenseStatus(String licenseStatus) {
		LicenseStatus = licenseStatus;
	}
	public String getDrivingLicenseType() {
		return DrivingLicenseType;
	}
	public void setDrivingLicenseType(String drivingLicenseType) {
		DrivingLicenseType = drivingLicenseType;
	}
	public String getCarDriverFlag() {
		return CarDriverFlag;
	}
	public void setCarDriverFlag(String carDriverFlag) {
		CarDriverFlag = carDriverFlag;
	}
	
	
	
}
