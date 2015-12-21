package test.com.shnlng.frog.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shnlng.frog.domain.CountRepo;
import com.shnlng.frog.domain.entity.CountEo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(com.shnlng.frog.FrogApplication.class)
public class CountRepoTest {
	@Autowired
	private CountRepo countRepo;

	@Test
	public void testCountFindAll(){
		 Iterable<CountEo> counts = countRepo.findAll();
	}

}
