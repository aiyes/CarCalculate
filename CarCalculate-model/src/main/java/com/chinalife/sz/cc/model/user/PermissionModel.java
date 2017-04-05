package com.chinalife.sz.cc.model.user;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
/**
 * 用户权限模型
 * @author MarsCheng
 * @email chengjie@sz.chinalife-p.com.cn
 * @create_date 2016年12月8日
 *
 */
@Alias("PermissionModel")
public class PermissionModel implements Serializable{
	private static final long serialVersionUID = -8351727269014839891L;
	private String roleCode;
	private String modelCode;
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getModelCode() {
		return modelCode;
	}
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}
	
	

}
