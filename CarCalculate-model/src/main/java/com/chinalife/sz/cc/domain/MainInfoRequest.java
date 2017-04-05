/**
 * @author MarsCheng
 * @email chengjie@sz.chinalife-p.com.cn
 * 2016年9月1日
 */
package com.chinalife.sz.cc.domain;

import java.io.Serializable;

/**
 * 先导信息请求javabean
 * @author MarsCheng
 * @email chengjie@sz.chinalife-p.com.cn
 * 2016年9月1日
 */
public class MainInfoRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//用户名
	private String userCde;
	//操作员代码
	private String operatorCode;
	//操作员名称
	private String operatorName;
	//是否同步交强险
	private String BZRealationFlag;
	// 计算方式，传统产品CalculateMode传1；电销CalculateMode传3；门店产品CalculateMode传2
	private String calculateMode;
	// 是否关联,1-关联单、2-单商业、3-单交强
	private String relationFlag; 
	
	
	
	public String getUserCde() {
		return userCde;
	}
	public void setUserCde(String userCde) {
		this.userCde = userCde;
	}
	
	public String getOperatorCode() {
		return operatorCode;
	}
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getBZRealationFlag() {
		return BZRealationFlag;
	}
	public void setBZRealationFlag(String bZRealationFlag) {
		BZRealationFlag = bZRealationFlag;
	}
	public String getCalculateMode() {
		return calculateMode;
	}
	public void setCalculateMode(String calculateMode) {
		this.calculateMode = calculateMode;
	}
	public String getRelationFlag() {
		return relationFlag;
	}
	public void setRelationFlag(String relationFlag) {
		this.relationFlag = relationFlag;
	}
	
	

}
