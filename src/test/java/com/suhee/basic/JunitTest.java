package com.suhee.basic;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.suhee.basic.config.MvcConfig;
import com.suhee.basic.dao.HomeDao;
import com.suhee.basic.model.MemberModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MvcConfig.class, MvcConfig.class})
@WebAppConfiguration
public class JunitTest {
	
	@Autowired
	private HomeDao homeDao;
	
	@Test
	public void test() throws Exception {
		List<MemberModel> MemberList = homeDao.test();
		for (MemberModel memberModel : MemberList) {
			log.info("memberModel: " + memberModel.toString());
		}
	}

}
