package com.beauate.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeauateCoreTest {
	/*
	 * @Autowired UserRepository userRepository;
	 */
    @Test
    public void contextLoads() {
        //assertThat(userRepository.findAll()).isNotNull();
    }

    @SpringBootApplication
    static class TestConfiguration {
    }
}
