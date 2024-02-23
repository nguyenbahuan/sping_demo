package com.example.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springmvc.model.Phones;

@Repository
public interface PhonesRepository extends JpaRepository<Phones, Long>{

}
