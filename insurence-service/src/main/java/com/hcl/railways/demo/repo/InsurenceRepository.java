package com.hcl.railways.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hcl.railways.demo.entity.Insurence;

@EnableJpaRepositories
public interface InsurenceRepository extends JpaRepository<Insurence, Long> {
}