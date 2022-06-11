package com.setu.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.setu.test.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
		
}
