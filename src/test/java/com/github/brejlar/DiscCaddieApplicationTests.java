package com.github.brejlar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.brejlar.DiscCaddieApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DiscCaddieApplication.class)
@WebAppConfiguration
public class DiscCaddieApplicationTests {

	@Test
	public void contextLoads() {
	}

}
