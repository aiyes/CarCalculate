package com.chinalife.sz.cc.domain;

import java.io.Serializable;

/**
 * Created by tianwei on 2016/7/20.
 */
public class CarInfoResponse  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6859697049751129128L;
	private String ActualValue;
	private String AreaCode;
	private String AreaName;
	private String BrandName;
	private String CarInsureRelation;
	private String CarKindCode;
	private String CarLossTypeRate;
	private String CarOwner;
	private String CarOwnerNature;
	private String CarOwnerIdentifyType;
	private String CarOwnerIdentifyNumber;
	private String CarType;
	private String ColorCode;
	private String CompleteKerbMass;
	private String CreditFlag;
	private String EcdemicFlag;
	private String EngineNo;
	private String EnrollDate;
	private String ExhaustScale;
	private String FrameNo;
	private String ImportFlag;
	private String LicenseNo;
	private String LicenseType;
	private String LicenseColorCode;
	private String NewCarFlag;
	private String PurchasePrice;
	private String OriginCarPrice;
	private String RbCode;
	private String RunMileRate;
	private String RunMilers;
	private String SafetyRate;
	private String SeatCount;
	private String TonCount;
	private String TransferDate;
	private String TransferFlag;
	private String UseNatureCode;
	private String UseYears;
	private String Vin;
	private String VehicleBrand1;
	private String VehicleLibraryCode;
	private String WholeWeight;
	private String FuleType;
	private String VehicleStyle;
	private String VehicleStyleDesc;
	private String LoanVehicleFlag;
	private String chgowerFlag;
	private String OtherNature2;
	private String SecondHandCarFlag;
	private String secondHandCarPrice;
	private String CarCheckStatus;
	private String CarChecker;
	private String AgreeDriverFlag;
	private String NewDeviceFlag;
	private String AddonCount;
	private String CertificateType;
	private String CertificateNo;
	private String CertificateDate;
	private String carModeid;
	private String carCheckReason;
	private String damagedFactorGrade;
	private String noDamageYears;
	private String RegistModelCode;
	private String vehicleModelAdjustValue;
	private String vehicleModelAdjustUpper;
	private String vehicleModelAdjustLower;
	private String CertifyDate;
	private String SpecialCarFlag;
	private String amoutTypeA;
	private String gtFloatRate;
	private String fairMarketValue;
	private String PurchaseReferencePrice;
	private String actualReferenceValue;
	private String carPriceType;
	private String platmodelCode;
	private String platmodelname;
	private String fcvehicle;
	private String platstandardname;
	private String lastPolicyStartDate;
	private String lastPolicyEndDate;
	private String carBuyDate;
	private String clauseType;
	private String isupdatprofitflag;
	private String queryAreaCode;
	private String policeFindDate;


	@Override
	public String toString() {
		return "CarInfoResponse{" +
				"ActualValue='" + ActualValue + '\'' +
				", AreaCode='" + AreaCode + '\'' +
				", AreaName='" + AreaName + '\'' +
				", BrandName='" + BrandName + '\'' +
				", CarInsureRelation='" + CarInsureRelation + '\'' +
				", CarKindCode='" + CarKindCode + '\'' +
				", CarLossTypeRate='" + CarLossTypeRate + '\'' +
				", CarOwner='" + CarOwner + '\'' +
				", CarOwnerNature='" + CarOwnerNature + '\'' +
				", CarOwnerIdentifyType='" + CarOwnerIdentifyType + '\'' +
				", CarOwnerIdentifyNumber='" + CarOwnerIdentifyNumber + '\'' +
				", CarType='" + CarType + '\'' +
				", ColorCode='" + ColorCode + '\'' +
				", CompleteKerbMass='" + CompleteKerbMass + '\'' +
				", CreditFlag='" + CreditFlag + '\'' +
				", EcdemicFlag='" + EcdemicFlag + '\'' +
				", EngineNo='" + EngineNo + '\'' +
				", EnrollDate='" + EnrollDate + '\'' +
				", ExhaustScale='" + ExhaustScale + '\'' +
				", FrameNo='" + FrameNo + '\'' +
				", ImportFlag='" + ImportFlag + '\'' +
				", LicenseNo='" + LicenseNo + '\'' +
				", LicenseType='" + LicenseType + '\'' +
				", LicenseColorCode='" + LicenseColorCode + '\'' +
				", NewCarFlag='" + NewCarFlag + '\'' +
				", PurchasePrice='" + PurchasePrice + '\'' +
				", OriginCarPrice='" + OriginCarPrice + '\'' +
				", RbCode='" + RbCode + '\'' +
				", RunMileRate='" + RunMileRate + '\'' +
				", RunMilers='" + RunMilers + '\'' +
				", SafetyRate='" + SafetyRate + '\'' +
				", SeatCount='" + SeatCount + '\'' +
				", TonCount='" + TonCount + '\'' +
				", TransferDate='" + TransferDate + '\'' +
				", TransferFlag='" + TransferFlag + '\'' +
				", UseNatureCode='" + UseNatureCode + '\'' +
				", UseYears='" + UseYears + '\'' +
				", Vin='" + Vin + '\'' +
				", VehicleBrand1='" + VehicleBrand1 + '\'' +
				", VehicleLibraryCode='" + VehicleLibraryCode + '\'' +
				", WholeWeight='" + WholeWeight + '\'' +
				", FuleType='" + FuleType + '\'' +
				", VehicleStyle='" + VehicleStyle + '\'' +
				", VehicleStyleDesc='" + VehicleStyleDesc + '\'' +
				", LoanVehicleFlag='" + LoanVehicleFlag + '\'' +
				", chgowerFlag='" + chgowerFlag + '\'' +
				", OtherNature2='" + OtherNature2 + '\'' +
				", SecondHandCarFlag='" + SecondHandCarFlag + '\'' +
				", secondHandCarPrice='" + secondHandCarPrice + '\'' +
				", CarCheckStatus='" + CarCheckStatus + '\'' +
				", CarChecker='" + CarChecker + '\'' +
				", AgreeDriverFlag='" + AgreeDriverFlag + '\'' +
				", NewDeviceFlag='" + NewDeviceFlag + '\'' +
				", AddonCount='" + AddonCount + '\'' +
				", CertificateType='" + CertificateType + '\'' +
				", CertificateNo='" + CertificateNo + '\'' +
				", CertificateDate='" + CertificateDate + '\'' +
				", carModeid='" + carModeid + '\'' +
				", carCheckReason='" + carCheckReason + '\'' +
				", damagedFactorGrade='" + damagedFactorGrade + '\'' +
				", noDamageYears='" + noDamageYears + '\'' +
				", RegistModelCode='" + RegistModelCode + '\'' +
				", vehicleModelAdjustValue='" + vehicleModelAdjustValue + '\'' +
				", vehicleModelAdjustUpper='" + vehicleModelAdjustUpper + '\'' +
				", vehicleModelAdjustLower='" + vehicleModelAdjustLower + '\'' +
				", CertifyDate='" + CertifyDate + '\'' +
				", SpecialCarFlag='" + SpecialCarFlag + '\'' +
				", amoutTypeA='" + amoutTypeA + '\'' +
				", gtFloatRate='" + gtFloatRate + '\'' +
				", fairMarketValue='" + fairMarketValue + '\'' +
				", PurchaseReferencePrice='" + PurchaseReferencePrice + '\'' +
				", actualReferenceValue='" + actualReferenceValue + '\'' +
				", carPriceType='" + carPriceType + '\'' +
				", platmodelCode='" + platmodelCode + '\'' +
				", platmodelname='" + platmodelname + '\'' +
				", fcvehicle='" + fcvehicle + '\'' +
				", platstandardname='" + platstandardname + '\'' +
				", lastPolicyStartDate='" + lastPolicyStartDate + '\'' +
				", lastPolicyEndDate='" + lastPolicyEndDate + '\'' +
				", carBuyDate='" + carBuyDate + '\'' +
				", clauseType='" + clauseType + '\'' +
				", isupdatprofitflag='" + isupdatprofitflag + '\'' +
				", queryAreaCode='" + queryAreaCode + '\'' +
				", policeFindDate='" + policeFindDate + '\'' +
				'}';
	}

	public String getActualValue() {
		return ActualValue;
	}

	public void setActualValue(String actualValue) {
		ActualValue = actualValue;
	}

	public String getAreaCode() {
		return AreaCode;
	}

	public void setAreaCode(String areaCode) {
		AreaCode = areaCode;
	}

	public String getAreaName() {
		return AreaName;
	}

	public void setAreaName(String areaName) {
		AreaName = areaName;
	}

	public String getBrandName() {
		return BrandName;
	}

	public void setBrandName(String brandName) {
		BrandName = brandName;
	}

	public String getCarInsureRelation() {
		return CarInsureRelation;
	}

	public void setCarInsureRelation(String carInsureRelation) {
		CarInsureRelation = carInsureRelation;
	}

	public String getCarKindCode() {
		return CarKindCode;
	}

	public void setCarKindCode(String carKindCode) {
		CarKindCode = carKindCode;
	}

	public String getCarLossTypeRate() {
		return CarLossTypeRate;
	}

	public void setCarLossTypeRate(String carLossTypeRate) {
		CarLossTypeRate = carLossTypeRate;
	}

	public String getCarOwner() {
		return CarOwner;
	}

	public void setCarOwner(String carOwner) {
		CarOwner = carOwner;
	}

	public String getCarOwnerNature() {
		return CarOwnerNature;
	}

	public void setCarOwnerNature(String carOwnerNature) {
		CarOwnerNature = carOwnerNature;
	}

	public String getCarOwnerIdentifyType() {
		return CarOwnerIdentifyType;
	}

	public void setCarOwnerIdentifyType(String carOwnerIdentifyType) {
		CarOwnerIdentifyType = carOwnerIdentifyType;
	}

	public String getCarOwnerIdentifyNumber() {
		return CarOwnerIdentifyNumber;
	}

	public void setCarOwnerIdentifyNumber(String carOwnerIdentifyNumber) {
		CarOwnerIdentifyNumber = carOwnerIdentifyNumber;
	}

	public String getCarType() {
		return CarType;
	}

	public void setCarType(String carType) {
		CarType = carType;
	}

	public String getColorCode() {
		return ColorCode;
	}

	public void setColorCode(String colorCode) {
		ColorCode = colorCode;
	}

	public String getCompleteKerbMass() {
		return CompleteKerbMass;
	}

	public void setCompleteKerbMass(String completeKerbMass) {
		CompleteKerbMass = completeKerbMass;
	}

	public String getCreditFlag() {
		return CreditFlag;
	}

	public void setCreditFlag(String creditFlag) {
		CreditFlag = creditFlag;
	}

	public String getEcdemicFlag() {
		return EcdemicFlag;
	}

	public void setEcdemicFlag(String ecdemicFlag) {
		EcdemicFlag = ecdemicFlag;
	}

	public String getEngineNo() {
		return EngineNo;
	}

	public void setEngineNo(String engineNo) {
		EngineNo = engineNo;
	}

	public String getEnrollDate() {
		return EnrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		EnrollDate = enrollDate;
	}

	public String getExhaustScale() {
		return ExhaustScale;
	}

	public void setExhaustScale(String exhaustScale) {
		ExhaustScale = exhaustScale;
	}

	public String getFrameNo() {
		return FrameNo;
	}

	public void setFrameNo(String frameNo) {
		FrameNo = frameNo;
	}

	public String getImportFlag() {
		return ImportFlag;
	}

	public void setImportFlag(String importFlag) {
		ImportFlag = importFlag;
	}

	public String getLicenseNo() {
		return LicenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		LicenseNo = licenseNo;
	}

	public String getLicenseType() {
		return LicenseType;
	}

	public void setLicenseType(String licenseType) {
		LicenseType = licenseType;
	}

	public String getLicenseColorCode() {
		return LicenseColorCode;
	}

	public void setLicenseColorCode(String licenseColorCode) {
		LicenseColorCode = licenseColorCode;
	}

	public String getNewCarFlag() {
		return NewCarFlag;
	}

	public void setNewCarFlag(String newCarFlag) {
		NewCarFlag = newCarFlag;
	}

	public String getPurchasePrice() {
		return PurchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		PurchasePrice = purchasePrice;
	}

	public String getOriginCarPrice() {
		return OriginCarPrice;
	}

	public void setOriginCarPrice(String originCarPrice) {
		OriginCarPrice = originCarPrice;
	}

	public String getRbCode() {
		return RbCode;
	}

	public void setRbCode(String rbCode) {
		RbCode = rbCode;
	}

	public String getRunMileRate() {
		return RunMileRate;
	}

	public void setRunMileRate(String runMileRate) {
		RunMileRate = runMileRate;
	}

	public String getRunMilers() {
		return RunMilers;
	}

	public void setRunMilers(String runMilers) {
		RunMilers = runMilers;
	}

	public String getSafetyRate() {
		return SafetyRate;
	}

	public void setSafetyRate(String safetyRate) {
		SafetyRate = safetyRate;
	}

	public String getSeatCount() {
		return SeatCount;
	}

	public void setSeatCount(String seatCount) {
		SeatCount = seatCount;
	}

	public String getTonCount() {
		return TonCount;
	}

	public void setTonCount(String tonCount) {
		TonCount = tonCount;
	}

	public String getTransferDate() {
		return TransferDate;
	}

	public void setTransferDate(String transferDate) {
		TransferDate = transferDate;
	}

	public String getTransferFlag() {
		return TransferFlag;
	}

	public void setTransferFlag(String transferFlag) {
		TransferFlag = transferFlag;
	}

	public String getUseNatureCode() {
		return UseNatureCode;
	}

	public void setUseNatureCode(String useNatureCode) {
		UseNatureCode = useNatureCode;
	}

	public String getUseYears() {
		return UseYears;
	}

	public void setUseYears(String useYears) {
		UseYears = useYears;
	}

	public String getVin() {
		return Vin;
	}

	public void setVin(String vin) {
		Vin = vin;
	}

	public String getVehicleBrand1() {
		return VehicleBrand1;
	}

	public void setVehicleBrand1(String vehicleBrand1) {
		VehicleBrand1 = vehicleBrand1;
	}

	public String getVehicleLibraryCode() {
		return VehicleLibraryCode;
	}

	public void setVehicleLibraryCode(String vehicleLibraryCode) {
		VehicleLibraryCode = vehicleLibraryCode;
	}

	public String getWholeWeight() {
		return WholeWeight;
	}

	public void setWholeWeight(String wholeWeight) {
		WholeWeight = wholeWeight;
	}

	public String getFuleType() {
		return FuleType;
	}

	public void setFuleType(String fuleType) {
		FuleType = fuleType;
	}

	public String getVehicleStyle() {
		return VehicleStyle;
	}

	public void setVehicleStyle(String vehicleStyle) {
		VehicleStyle = vehicleStyle;
	}

	public String getVehicleStyleDesc() {
		return VehicleStyleDesc;
	}

	public void setVehicleStyleDesc(String vehicleStyleDesc) {
		VehicleStyleDesc = vehicleStyleDesc;
	}

	public String getLoanVehicleFlag() {
		return LoanVehicleFlag;
	}

	public void setLoanVehicleFlag(String loanVehicleFlag) {
		LoanVehicleFlag = loanVehicleFlag;
	}

	public String getChgowerFlag() {
		return chgowerFlag;
	}

	public void setChgowerFlag(String chgowerFlag) {
		this.chgowerFlag = chgowerFlag;
	}

	public String getOtherNature2() {
		return OtherNature2;
	}

	public void setOtherNature2(String otherNature2) {
		OtherNature2 = otherNature2;
	}

	public String getSecondHandCarFlag() {
		return SecondHandCarFlag;
	}

	public void setSecondHandCarFlag(String secondHandCarFlag) {
		SecondHandCarFlag = secondHandCarFlag;
	}

	public String getSecondHandCarPrice() {
		return secondHandCarPrice;
	}

	public void setSecondHandCarPrice(String secondHandCarPrice) {
		this.secondHandCarPrice = secondHandCarPrice;
	}

	public String getCarCheckStatus() {
		return CarCheckStatus;
	}

	public void setCarCheckStatus(String carCheckStatus) {
		CarCheckStatus = carCheckStatus;
	}

	public String getCarChecker() {
		return CarChecker;
	}

	public void setCarChecker(String carChecker) {
		CarChecker = carChecker;
	}

	public String getAgreeDriverFlag() {
		return AgreeDriverFlag;
	}

	public void setAgreeDriverFlag(String agreeDriverFlag) {
		AgreeDriverFlag = agreeDriverFlag;
	}

	public String getNewDeviceFlag() {
		return NewDeviceFlag;
	}

	public void setNewDeviceFlag(String newDeviceFlag) {
		NewDeviceFlag = newDeviceFlag;
	}

	public String getAddonCount() {
		return AddonCount;
	}

	public void setAddonCount(String addonCount) {
		AddonCount = addonCount;
	}

	public String getCertificateType() {
		return CertificateType;
	}

	public void setCertificateType(String certificateType) {
		CertificateType = certificateType;
	}

	public String getCertificateNo() {
		return CertificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		CertificateNo = certificateNo;
	}

	public String getCertificateDate() {
		return CertificateDate;
	}

	public void setCertificateDate(String certificateDate) {
		CertificateDate = certificateDate;
	}

	public String getCarModeid() {
		return carModeid;
	}

	public void setCarModeid(String carModeid) {
		this.carModeid = carModeid;
	}

	public String getCarCheckReason() {
		return carCheckReason;
	}

	public void setCarCheckReason(String carCheckReason) {
		this.carCheckReason = carCheckReason;
	}

	public String getDamagedFactorGrade() {
		return damagedFactorGrade;
	}

	public void setDamagedFactorGrade(String damagedFactorGrade) {
		this.damagedFactorGrade = damagedFactorGrade;
	}

	public String getNoDamageYears() {
		return noDamageYears;
	}

	public void setNoDamageYears(String noDamageYears) {
		this.noDamageYears = noDamageYears;
	}

	public String getRegistModelCode() {
		return RegistModelCode;
	}

	public void setRegistModelCode(String registModelCode) {
		RegistModelCode = registModelCode;
	}

	public String getVehicleModelAdjustValue() {
		return vehicleModelAdjustValue;
	}

	public void setVehicleModelAdjustValue(String vehicleModelAdjustValue) {
		this.vehicleModelAdjustValue = vehicleModelAdjustValue;
	}

	public String getVehicleModelAdjustUpper() {
		return vehicleModelAdjustUpper;
	}

	public void setVehicleModelAdjustUpper(String vehicleModelAdjustUpper) {
		this.vehicleModelAdjustUpper = vehicleModelAdjustUpper;
	}

	public String getVehicleModelAdjustLower() {
		return vehicleModelAdjustLower;
	}

	public void setVehicleModelAdjustLower(String vehicleModelAdjustLower) {
		this.vehicleModelAdjustLower = vehicleModelAdjustLower;
	}

	public String getCertifyDate() {
		return CertifyDate;
	}

	public void setCertifyDate(String certifyDate) {
		CertifyDate = certifyDate;
	}

	public String getSpecialCarFlag() {
		return SpecialCarFlag;
	}

	public void setSpecialCarFlag(String specialCarFlag) {
		SpecialCarFlag = specialCarFlag;
	}

	public String getAmoutTypeA() {
		return amoutTypeA;
	}

	public void setAmoutTypeA(String amoutTypeA) {
		this.amoutTypeA = amoutTypeA;
	}

	public String getGtFloatRate() {
		return gtFloatRate;
	}

	public void setGtFloatRate(String gtFloatRate) {
		this.gtFloatRate = gtFloatRate;
	}

	public String getFairMarketValue() {
		return fairMarketValue;
	}

	public void setFairMarketValue(String fairMarketValue) {
		this.fairMarketValue = fairMarketValue;
	}

	public String getPurchaseReferencePrice() {
		return PurchaseReferencePrice;
	}

	public void setPurchaseReferencePrice(String purchaseReferencePrice) {
		PurchaseReferencePrice = purchaseReferencePrice;
	}

	public String getActualReferenceValue() {
		return actualReferenceValue;
	}

	public void setActualReferenceValue(String actualReferenceValue) {
		this.actualReferenceValue = actualReferenceValue;
	}

	public String getCarPriceType() {
		return carPriceType;
	}

	public void setCarPriceType(String carPriceType) {
		this.carPriceType = carPriceType;
	}

	public String getPlatmodelCode() {
		return platmodelCode;
	}

	public void setPlatmodelCode(String platmodelCode) {
		this.platmodelCode = platmodelCode;
	}

	public String getPlatmodelname() {
		return platmodelname;
	}

	public void setPlatmodelname(String platmodelname) {
		this.platmodelname = platmodelname;
	}

	public String getFcvehicle() {
		return fcvehicle;
	}

	public void setFcvehicle(String fcvehicle) {
		this.fcvehicle = fcvehicle;
	}

	public String getPlatstandardname() {
		return platstandardname;
	}

	public void setPlatstandardname(String platstandardname) {
		this.platstandardname = platstandardname;
	}

	public String getLastPolicyStartDate() {
		return lastPolicyStartDate;
	}

	public void setLastPolicyStartDate(String lastPolicyStartDate) {
		this.lastPolicyStartDate = lastPolicyStartDate;
	}

	public String getLastPolicyEndDate() {
		return lastPolicyEndDate;
	}

	public void setLastPolicyEndDate(String lastPolicyEndDate) {
		this.lastPolicyEndDate = lastPolicyEndDate;
	}

	public String getCarBuyDate() {
		return carBuyDate;
	}

	public void setCarBuyDate(String carBuyDate) {
		this.carBuyDate = carBuyDate;
	}

	public String getClauseType() {
		return clauseType;
	}

	public void setClauseType(String clauseType) {
		this.clauseType = clauseType;
	}

	public String getIsupdatprofitflag() {
		return isupdatprofitflag;
	}

	public void setIsupdatprofitflag(String isupdatprofitflag) {
		this.isupdatprofitflag = isupdatprofitflag;
	}

	public String getQueryAreaCode() {
		return queryAreaCode;
	}

	public void setQueryAreaCode(String queryAreaCode) {
		this.queryAreaCode = queryAreaCode;
	}

	public String getPoliceFindDate() {
		return policeFindDate;
	}

	public void setPoliceFindDate(String policeFindDate) {
		this.policeFindDate = policeFindDate;
	}
}