package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.models.Admin;

@Repository
public interface AdminDaoInterface extends JpaRepository<Admin, Integer>{

}
