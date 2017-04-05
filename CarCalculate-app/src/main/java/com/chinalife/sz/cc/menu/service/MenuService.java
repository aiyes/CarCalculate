package com.chinalife.sz.cc.menu.service;

import java.util.List;

import com.chinalife.sz.cc.model.menu.MenuDTO;
import com.prs.framework.core.exception.BusinessException;

public interface MenuService {
	
	/*
	 * 获取所有的菜单类型信息
	 */
	public List<MenuDTO> findAllMenu() throws BusinessException;
	
}
