package com.ecommerce.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.sportyshoes.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {

}