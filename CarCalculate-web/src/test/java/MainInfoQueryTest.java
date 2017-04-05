import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chinalife.sz.cc.domain.MainInfoRequest;
import com.chinalife.sz.cc.domain.MainResponse;
import com.chinalife.sz.cc.service.WebUtils;

/**
 * @author MarsCheng
 * @email chengjie@sz.chinalife-p.com.cn
 * 2016年9月1日
 */

/**
 * @author MarsCheng
 * @email chengjie@sz.chinalife-p.com.cn
 * 2016年9月1日
 */

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:web/springmvc-servlet.xml","classpath*:web/web-context.xml" })
public class MainInfoQueryTest {

	@Autowired
	private WebUtils webUtils;
	
	@Test
	public void test() {
		MainResponse mainResponse = new MainResponse();
		MainInfoRequest mainrequest = new MainInfoRequest();
		mainrequest.setUserCde("chinalife");
		mainrequest.setOperatorCode("130203198912030014");
		mainrequest.setOperatorName("张三");
		mainrequest.setBZRealationFlag("1");
		mainrequest.setRelationFlag("1");
		mainrequest.setCalculateMode("3");
		
		mainResponse = webUtils.submit(mainrequest, "09", mainResponse);
		
		String agentCode = mainResponse.getAgentCode();
		
		System.out.println(agentCode);
		
		
//		fail("Not yet implemented");
	}

}
