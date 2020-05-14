package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.models.LigneDePiece;

@Repository
public interface LigneDePieceDaoInterface extends JpaRepository<LigneDePiece, Integer>{

}
