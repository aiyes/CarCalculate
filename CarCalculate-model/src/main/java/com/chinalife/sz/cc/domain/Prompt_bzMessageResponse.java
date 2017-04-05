package com.chinalife.sz.cc.domain;

import java.io.Serializable;

/**
 * Created by tianwei on 2016/7/20.
 * 平台返回交强险信息
 */
public class Prompt_bzMessageResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8943045866463908919L;
	private String MotorUsageTypeMessageType;
	private String FleetMessageType;
	private String MileageFactorMessageType;

	@Override
	public String toString() {
		return "Prompt_bzMessageResponse{" +
				"MotorUsageTypeMessageType='" + MotorUsageTypeMessageType + '\'' +
				", FleetMessageType='" + FleetMessageType + '\'' +
				", MileageFactorMessageType='" + MileageFactorMessageType + '\'' +
				'}';
	}

	public String getMotorUsageTypeMessageType() {
		return MotorUsageTypeMessageType;
	}

	public void setMotorUsageTypeMessageType(String motorUsageTypeMessageType) {
		MotorUsageTypeMessageType = motorUsageTypeMessageType;
	}

	public String getFleetMessageType() {
		return FleetMessageType;
	}

	public void setFleetMessageType(String fleetMessageType) {
		FleetMessageType = fleetMessageType;
	}

	public String getMileageFactorMessageType() {
		return MileageFactorMessageType;
	}

	public void setMileageFactorMessageType(String mileageFactorMessageType) {
		MileageFactorMessageType = mileageFactorMessageType;
	}
}
