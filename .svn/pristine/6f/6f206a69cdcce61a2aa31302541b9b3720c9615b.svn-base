package com.chinalife.sz.cc.log;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chinalife.sz.cc.log.service.LogService;
import com.chinalife.sz.cc.model.log.LogDTO;
import com.prs.framework.core.exception.BusinessException;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:biz/biz-context.xml",
		"classpath*:biz/remote-context.xml" })
public class LogServiceTest {

	@Resource
	private LogService logService;

	@Test
	public void test() {

		LogDTO dto = new LogDTO();
		dto.setServiceNme("serviceNme");
		// dto.setReqTm(new Date());
		try {
			logService.addLog(dto);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

	

}
