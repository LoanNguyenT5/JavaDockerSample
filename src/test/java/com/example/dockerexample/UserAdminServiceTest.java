package com.example.dockerexample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dockerexample.entity.AuthenticationProvider;
import com.example.dockerexample.entity.UserAdmin;
import com.example.dockerexample.repository.UserAdminRepository;
import com.example.dockerexample.service.UserAdminService;

import antlr.collections.List;

@SpringBootTest
public class UserAdminServiceTest {

    @Mock
    UserAdminRepository repo;

    @InjectMocks
    UserAdminService userAdminService;

    @Test
    public void insertUser() {
        UserAdmin user = new UserAdmin();
        user.setAuthProvider(AuthenticationProvider.GOOGLE);
        user.setPassword("123");
        user.setUserId("loan");
        
        UserAdmin user2 = new UserAdmin();
        user2.setAuthProvider(AuthenticationProvider.GOOGLE);
        user2.setPassword("123");
        user2.setUserId("loan");
        

        when(repo.save(user)).thenReturn(user);//
        assertEquals(user, userAdminService.insertUser(user));
    }
    
    @Test
    public void getList() {
        UserAdmin user = new UserAdmin();
        user.setAuthProvider(AuthenticationProvider.GOOGLE);
        user.setPassword("123");
        user.setUserId("loan");
        
        UserAdmin user2 = new UserAdmin();
        user2.setAuthProvider(AuthenticationProvider.GOOGLE);
        user2.setPassword("1234");
        user2.setUserId("loan1");
        ArrayList<UserAdmin> list = new ArrayList<UserAdmin>();
        list.add(user);
       // list.add(user2);
        when(repo.findAll()).thenReturn(list);
        assertEquals(2, userAdminService.findAllUsers().size());
    }

}
