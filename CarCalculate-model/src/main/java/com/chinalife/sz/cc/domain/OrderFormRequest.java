package com.chinalife.sz.cc.domain;

import java.io.Serializable;

/**
 * Created by tianwei on 2016/12/19.
 */
public class OrderFormRequest implements Serializable {
    private static final long serialVersionUID = -429326552873598248L;
    private Integer id;
    private String proposalNo;
    private String appliName;
    private String licenseNo;
    private String frameNo;
    private String  handlerName;
    private String inputStartDate;
    private String inputEndDate;


    @Override
    public String toString() {
        return "OrderFormRequest{" +
                "id=" + id +
                ", proposalNo='" + proposalNo + '\'' +
                ", appliName='" + appliName + '\'' +
                ", licenseNo='" + licenseNo + '\'' +
                ", frameNo='" + frameNo + '\'' +
                ", handlerCode='" + handlerName + '\'' +
                ", inputStartDate=" + inputStartDate +
                ", inputEndDate=" + inputEndDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getProposalNo() {
        return proposalNo;
    }

    public void setProposalNo(String proposalNo) {
        this.proposalNo = proposalNo;
    }

    public String getAppliName() {
        return appliName;
    }

    public void setAppliName(String appliName) {
        this.appliName = appliName;
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

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getInputStartDate() {
        return inputStartDate;
    }

    public void setInputStartDate(String inputStartDate) {
        this.inputStartDate = inputStartDate;
    }

    public String getInputEndDate() {
        return inputEndDate;
    }

    public void setInputEndDate(String inputEndDate) {
        this.inputEndDate = inputEndDate;
    }
}
