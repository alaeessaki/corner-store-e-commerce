package com.youcode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.models.Payment;

@Repository
public interface PaymentDaoInterface extends JpaRepository<Payment, Integer>{

}
