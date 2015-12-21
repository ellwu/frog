package test.com.shnlng.frog.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shnlng.frog.service.ResourceSo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(com.shnlng.frog.FrogApplication.class)
public class TestResourceSo {
	@Autowired
	private ResourceSo rSo;
	
	@Test
	public void testGetUrls(){
		System.out.println(rSo.popUrls("xx01"));
	}
}
