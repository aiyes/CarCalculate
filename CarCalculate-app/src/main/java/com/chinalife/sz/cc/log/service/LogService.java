package com.chinalife.sz.cc.log.service;

import com.chinalife.sz.cc.model.log.LogDTO;
import com.prs.framework.core.exception.BusinessException;

public interface LogService {
		//新增日志
		public void addLog(LogDTO dto) throws BusinessException ;
	
}
