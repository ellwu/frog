package test.com.shnlng.frog.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shnlng.frog.domain.BindingRepo;
import com.shnlng.frog.domain.entity.BindingEo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(com.shnlng.frog.FrogApplication.class)
public class BindingRepoTest {

	@Autowired
	private BindingRepo bRepo;

	@Test
	public void testFind() {
		BindingEo b = bRepo.findByDeviceId("1001");
	}

}
