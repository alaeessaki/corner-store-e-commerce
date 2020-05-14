package com.youcode.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.dto.User;

@Repository
public interface UserDaoInterface extends JpaRepository<User, Integer>{
	public Optional<User> findByUsername(String username);
}
