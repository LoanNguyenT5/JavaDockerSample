package com.example.dockerexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.dockerexample.entity.UserAdmin;

@Repository
public interface UserAdminRepository extends CrudRepository<UserAdmin, Long> {

}
