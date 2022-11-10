package com.ecommerce.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.sportyshoes.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}