package com.chinalife.sz.cc.model.user;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 用户角色模型
 * @author MarsCheng
 * @email chengjie@sz.chinalife-p.com.cn
 * @create_date 2016年12月8日
 *
 */
@Alias("RoleModel")
public class RoleModel implements Serializable{
	
	private static final long serialVersionUID = -8351727269014839890L;
	private String id;
	private String userCode;
	private String roleCode;
	
	
	public String getId() {
		return id;
	}
	public void setId() {
		this.id = this.userCode+this.roleCode;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	
	
}
