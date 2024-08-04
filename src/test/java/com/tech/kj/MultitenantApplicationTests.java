package com.tech.kj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(TestContainerConfig.class)
class MultitenantApplicationTests {

	@Test
	void contextLoads() {
	}

}
