package com.example.bike.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bike.entities.Bike;

public interface BikeRepositories extends JpaRepository<Bike,String>
{

}
