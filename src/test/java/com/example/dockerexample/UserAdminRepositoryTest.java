package com.example.dockerexample;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dockerexample.entity.AuthenticationProvider;
import com.example.dockerexample.entity.UserAdmin;
import com.example.dockerexample.repository.UserAdminRepository;

@SpringBootTest
public class UserAdminRepositoryTest {
    @Autowired
    UserAdminRepository userAdminRepository;
       
    @Test
    public void testFindUser() {
        UserAdmin user = userAdminRepository.findByUserId("admin");
        assertThat(user.getUserId()).isEqualTo("admin");
    }
    @Test
    public void testInsertUser() {
        UserAdmin user = new UserAdmin();
        user.setAuthProvider(AuthenticationProvider.GOOGLE);
        user.setPassword("123");
        user.setUserId("loan");
        UserAdmin userSave = userAdminRepository.save(user);
        assertThat("loan").isEqualTo(userSave.getUserId());
    }

}
