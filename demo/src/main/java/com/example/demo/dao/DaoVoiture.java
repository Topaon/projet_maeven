package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Voiture;

public interface DaoVoiture extends JpaRepository<Voiture, Long>{

}
