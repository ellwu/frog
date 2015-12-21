package test.com.shnlng.frog.domain;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shnlng.frog.domain.Count;
import com.shnlng.frog.domain.CountRepo;
import com.shnlng.frog.util.IdGen;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(com.shnlng.frog.FrogApplication.class)
public class CountRepoTest {
	@Autowired
	private CountRepo countRepo;

	@Test
	public void testCountFindAll(){
		 Iterable<Count> counts = countRepo.findAll();
	}

	@Test
	public void testCountCreate(){
		Count c = new Count();
		c.setCountId(IdGen.id32());
		c.setDeviceId("10001");
		c.setResourceId("R0001");
		c.setTime(200);
		c.setCount(10);
		c.setCountTime(new Date());
		c.setUploadTime(new Date());
		
		countRepo.save(c);
	}
}
