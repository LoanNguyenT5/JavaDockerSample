package com.example.dockerexample;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dockerexample.controller.UserAdminController;
import com.example.dockerexample.service.UserAdminService;

@SpringBootTest
class DockerexampleApplicationTests {

    @Autowired
    private UserAdminController userAdminController;

    @Autowired
    private UserAdminService userAdminService;
    
	@Test
	void contextLoads() {
	    assertThat(userAdminController).isNotNull();
        assertThat(userAdminService).isNotNull();
	}

}
