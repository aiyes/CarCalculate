package com.chinalife.sz.cc.log.action;

import com.prs.framework.core.common.model.ServiceRequest;
import com.prs.framework.core.common.model.ServiceResponse;
import com.prs.framework.core.exception.BusinessServiceException;

public interface LogAction {
	//新增日志主表
	ServiceResponse addLog (ServiceRequest serviceRequest) throws BusinessServiceException;
}
