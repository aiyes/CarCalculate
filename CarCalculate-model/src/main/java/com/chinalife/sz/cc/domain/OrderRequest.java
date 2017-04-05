package com.chinalife.sz.cc.domain;

import java.io.Serializable;

/**
 * Created by tianwei on 2016/12/14.
 */
public class OrderRequest implements Serializable {
    private static final long serialVersionUID = 6675251046285943605L;
    private String requestType;
    private String proposalNo;
    private String tmkFlag;
    private String relationFlag;
    private String comcode;
    private String handler1Code;
    private String handler1Name;
    private String combosCode;
    private String MainSubPolicyNo;
    private String MainSubRemark;
    private String policyPrintType;
    private String logonRole;
    private String licenseNo;
    private String frameNo;
    private ApplicantRequest applicant;
    private InsuredDataRequest InsuredData;
    private InsuredDataRequest carOwnerDataEhm;
//    other message
    private String argueSolution;
    private String arbitBoardName;
    private String carCheckStatus;
    private String carChecker;
    private String carCheckDate;
    private String carCheckReason;
//团队代理信息
   private AheadInfoRequest  aheadInfoEhm;


    @Override
    public String toString() {
        return "OrderRequest{" +
                "requestType='" + requestType + '\'' +
                ", proposalNo='" + proposalNo + '\'' +
                ", tmkFlag='" + tmkFlag + '\'' +
                ", relationFlag='" + relationFlag + '\'' +
                ", comcode='" + comcode + '\'' +
                ", handler1Code='" + handler1Code + '\'' +
                ", handler1Name='" + handler1Name + '\'' +
                ", combosCode='" + combosCode + '\'' +
                ", MainSubPolicyNo='" + MainSubPolicyNo + '\'' +
                ", MainSubRemark='" + MainSubRemark + '\'' +
                ", policyPrintType='" + policyPrintType + '\'' +
                ", logonRole='" + logonRole + '\'' +
                ", licenseNo='" + licenseNo + '\'' +
                ", frameNo='" + frameNo + '\'' +
                ", applicant=" + applicant +
                ", InsuredData=" + InsuredData +
                ", carOwnerDataEhm=" + carOwnerDataEhm +
                ", argueSolution='" + argueSolution + '\'' +
                ", arbitBoardName='" + arbitBoardName + '\'' +
                ", carCheckStatus='" + carCheckStatus + '\'' +
                ", carChecker='" + carChecker + '\'' +
                ", carCheckDate='" + carCheckDate + '\'' +
                ", carCheckReason='" + carCheckReason + '\'' +
                ", aheadInfoEhm=" + aheadInfoEhm +
                '}';
    }

    public String getHandler1Name() {
        return handler1Name;
    }

    public void setHandler1Name(String handler1Name) {
        this.handler1Name = handler1Name;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getFrameNo() {
        return frameNo;
    }

    public void setFrameNo(String frameNo) {
        this.frameNo = frameNo;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getProposalNo() {
        return proposalNo;
    }

    public void setProposalNo(String proposalNo) {
        this.proposalNo = proposalNo;
    }

    public String getTmkFlag() {
        return tmkFlag;
    }

    public void setTmkFlag(String tmkFlag) {
        this.tmkFlag = tmkFlag;
    }

    public String getRelationFlag() {
        return relationFlag;
    }

    public void setRelationFlag(String relationFlag) {
        this.relationFlag = relationFlag;
    }

    public String getComcode() {
        return comcode;
    }

    public void setComcode(String comcode) {
        this.comcode = comcode;
    }

    public String getHandler1Code() {
        return handler1Code;
    }

    public void setHandler1Code(String handler1Code) {
        this.handler1Code = handler1Code;
    }

    public String getCombosCode() {
        return combosCode;
    }

    public void setCombosCode(String combosCode) {
        this.combosCode = combosCode;
    }

    public String getMainSubPolicyNo() {
        return MainSubPolicyNo;
    }

    public void setMainSubPolicyNo(String mainSubPolicyNo) {
        MainSubPolicyNo = mainSubPolicyNo;
    }

    public String getMainSubRemark() {
        return MainSubRemark;
    }

    public void setMainSubRemark(String mainSubRemark) {
        MainSubRemark = mainSubRemark;
    }

    public String getPolicyPrintType() {
        return policyPrintType;
    }

    public void setPolicyPrintType(String policyPrintType) {
        this.policyPrintType = policyPrintType;
    }

    public String getLogonRole() {
        return logonRole;
    }

    public void setLogonRole(String logonRole) {
        this.logonRole = logonRole;
    }

    public ApplicantRequest getApplicant() {
        return applicant;
    }

    public void setApplicant(ApplicantRequest applicant) {
        this.applicant = applicant;
    }

    public InsuredDataRequest getInsuredData() {
        return InsuredData;
    }

    public void setInsuredData(InsuredDataRequest insuredData) {
        InsuredData = insuredData;
    }

    public InsuredDataRequest getCarOwnerDataEhm() {
        return carOwnerDataEhm;
    }

    public void setCarOwnerDataEhm(InsuredDataRequest carOwnerDataEhm) {
        this.carOwnerDataEhm = carOwnerDataEhm;
    }

    public String getArgueSolution() {
        return argueSolution;
    }

    public void setArgueSolution(String argueSolution) {
        this.argueSolution = argueSolution;
    }

    public String getArbitBoardName() {
        return arbitBoardName;
    }

    public void setArbitBoardName(String arbitBoardName) {
        this.arbitBoardName = arbitBoardName;
    }

    public String getCarCheckStatus() {
        return carCheckStatus;
    }

    public void setCarCheckStatus(String carCheckStatus) {
        this.carCheckStatus = carCheckStatus;
    }

    public String getCarChecker() {
        return carChecker;
    }

    public void setCarChecker(String carChecker) {
        this.carChecker = carChecker;
    }

    public String getCarCheckDate() {
        return carCheckDate;
    }

    public void setCarCheckDate(String carCheckDate) {
        this.carCheckDate = carCheckDate;
    }

    public String getCarCheckReason() {
        return carCheckReason;
    }

    public void setCarCheckReason(String carCheckReason) {
        this.carCheckReason = carCheckReason;
    }

    public AheadInfoRequest getAheadInfoEhm() {
        return aheadInfoEhm;
    }

    public void setAheadInfoEhm(AheadInfoRequest aheadInfoEhm) {
        this.aheadInfoEhm = aheadInfoEhm;
    }
}
