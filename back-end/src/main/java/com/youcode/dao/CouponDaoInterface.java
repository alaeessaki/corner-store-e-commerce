package com.youcode.dao;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.models.Coupon;

@Repository
public interface CouponDaoInterface extends JpaRepository<Coupon, Integer>{
	Optional<Coupon> findByCode(String code);
}
