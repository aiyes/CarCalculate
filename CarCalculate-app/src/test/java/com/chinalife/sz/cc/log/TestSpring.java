package com.chinalife.sz.cc.log;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chinalife.sz.carcalculate.service.WebService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:web/application.xml"})
public class TestSpring {
	@Autowired
	private List<WebService>  webserviceList;
	@Test
	public void testMain(){
		System.out.println(webserviceList.size());
	}

}
