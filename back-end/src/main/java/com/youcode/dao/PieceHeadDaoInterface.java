package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.models.PieceHead;

@Repository
public interface PieceHeadDaoInterface extends JpaRepository<PieceHead, Integer>{

}
