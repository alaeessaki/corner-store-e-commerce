package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.models.Piece;

@Repository
public interface PieceDaoInterface extends JpaRepository<Piece, Integer>{

}
