package test.com.shnlng.frog.domain;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shnlng.frog.domain.TargetRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(com.shnlng.frog.FrogApplication.class)
public class TargetRepoTest {

	@Autowired
	private TargetRepo tRepo;

	@Test
	public void testFind() {
		tRepo.findByMerchantId("1001", new Date());
	}
}
