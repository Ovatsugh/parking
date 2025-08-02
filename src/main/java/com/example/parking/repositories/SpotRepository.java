package com.example.parking.repositories;

import com.example.parking.domain.spot.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotRepository extends JpaRepository<Spot, Integer> {
}
