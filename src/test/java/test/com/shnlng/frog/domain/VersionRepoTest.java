package test.com.shnlng.frog.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shnlng.frog.domain.VersionRepo;
import com.shnlng.frog.domain.entity.VersionEo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(com.shnlng.frog.FrogApplication.class)
public class VersionRepoTest {

	@Autowired
	private VersionRepo vRepo;

	@Test
	public void testFind() {
		VersionEo v = vRepo.findApplyVersion();
		System.out.println(v);
	}
}
