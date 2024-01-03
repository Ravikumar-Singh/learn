package com.example.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.learn.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

}
