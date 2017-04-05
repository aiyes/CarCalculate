package com.chinalife.sz.cc.domain;

import java.io.Serializable;

/**
 * Created by tianwei on 2016/12/14.
 */
//团队代理信息
public class AheadInfoRequest implements Serializable {
    private static final long serialVersionUID = 6616217951296637127L;
    private String channelType;
    private String groupCode;
    private String businessSource;
    private String agentCode;
    private String agreementNo;
    private String handlerCode;
    private String handlerName;
    private String salesPersonCode;
    private String certificateNo;
    private String mobile;


    @Override
    public String toString() {
        return "AheadInfoRequest{" +
                "channelType='" + channelType + '\'' +
                ", groupCode='" + groupCode + '\'' +
                ", businessSource='" + businessSource + '\'' +
                ", agentCode='" + agentCode + '\'' +
                ", agreementNo='" + agreementNo + '\'' +
                ", handlerCode='" + handlerCode + '\'' +
                ", handlerName='" + handlerName + '\'' +
                ", salesPersonCode='" + salesPersonCode + '\'' +
                ", certificateNo='" + certificateNo + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getBusinessSource() {
        return businessSource;
    }

    public void setBusinessSource(String businessSource) {
        this.businessSource = businessSource;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getAgreementNo() {
        return agreementNo;
    }

    public void setAgreementNo(String agreementNo) {
        this.agreementNo = agreementNo;
    }

    public String getHandlerCode() {
        return handlerCode;
    }

    public void setHandlerCode(String handlerCode) {
        this.handlerCode = handlerCode;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getSalesPersonCode() {
        return salesPersonCode;
    }

    public void setSalesPersonCode(String salesPersonCode) {
        this.salesPersonCode = salesPersonCode;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
