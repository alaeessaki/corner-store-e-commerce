package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.models.Role;

@Repository
public interface RoleDaoInterface extends JpaRepository<Role, Integer>{

}
