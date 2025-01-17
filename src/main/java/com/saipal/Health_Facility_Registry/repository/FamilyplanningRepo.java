package com.saipal.Health_Facility_Registry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.Familyplanning;

@Repository
public interface FamilyplanningRepo extends JpaRepository<Familyplanning, Integer> {

}
