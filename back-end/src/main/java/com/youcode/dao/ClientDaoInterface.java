package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.models.Client;

@Repository
public interface ClientDaoInterface extends JpaRepository<Client, Integer>{

}
