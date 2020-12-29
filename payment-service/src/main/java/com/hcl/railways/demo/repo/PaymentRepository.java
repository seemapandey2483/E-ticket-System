package com.hcl.railways.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hcl.railways.demo.entity.Payment;
import com.hcl.railways.demo.model.PaymentInfo;

@EnableJpaRepositories
public interface PaymentRepository extends JpaRepository<Payment, Long> {
  }