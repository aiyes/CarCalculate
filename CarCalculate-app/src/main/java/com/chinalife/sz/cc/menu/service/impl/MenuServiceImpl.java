package com.chinalife.sz.cc.menu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinalife.sz.cc.menu.mapper.MenuMapper;
import com.chinalife.sz.cc.menu.service.MenuService;
import com.chinalife.sz.cc.model.menu.MenuDTO;
import com.prs.framework.core.exception.BusinessException;

/**
 * <p>Title: UserInfoService</p>
 * <p>Description: 车险报价系统 </p>
 * <p>Company: 中国人寿财产保险股份有限公司深圳市分公司</p>
 * @author liangjihong@sz.chinalife-p.com.cn
 * @date 2016年8月1日
 * @version 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MenuServiceImpl implements  MenuService{
	@Resource
	private MenuMapper menuMapper;

	/*
	 * 获取所有的菜单信息
	 * @see com.chinalife.sz.carcalculate.menu.service.MenuService#findAllMenu()
	 */
	@Override
	public List<MenuDTO> findAllMenu() throws BusinessException {
		return  menuMapper.findAllMenu();
	}

}
