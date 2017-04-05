package com.chinalife.sz.cc.model.order;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * Created by tianwei on 2016/12/16.
 */
@Alias("OrderInfoDTO")
public class OrderInfoDTO  implements Serializable{
    private static final long serialVersionUID = 2758731496763972093L;
    private Long id;
    private String proposalNo;
    private String appliName;
    private String licenseNo;
    private String frameNo;
    private String inputDate;
    private String handlerName;


    @Override
    public String toString() {
        return "OrderInfoDTO{" +
                "id=" + id +
                ", proposalNo='" + proposalNo + '\'' +
                ", appliName='" + appliName + '\'' +
                ", licenseNo='" + licenseNo + '\'' +
                ", frameNo='" + frameNo + '\'' +
                ", inputDate=" + inputDate +
                ", handlerName='" + handlerName + '\'' +
                '}';
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public Long getId() {
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

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }
}
