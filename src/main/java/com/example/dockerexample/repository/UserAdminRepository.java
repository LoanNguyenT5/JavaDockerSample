package com.example.dockerexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.dockerexample.entity.UserAdmin;

@Repository
public interface UserAdminRepository extends JpaRepository<UserAdmin, Long> {
    @Query("SELECT u FROM UserAdmin u WHERE u.userId = :userName")
    UserAdmin findByUserId(@Param("userName") final String userName);
}
