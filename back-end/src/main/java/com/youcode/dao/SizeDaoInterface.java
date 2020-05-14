package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.models.Size;

@Repository
public interface SizeDaoInterface extends JpaRepository<Size, Integer>{

}
