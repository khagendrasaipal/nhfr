package com.saipal.Health_Facility_Registry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.Province;

@Repository
public interface ProvinceRepo extends JpaRepository<Province, Integer> {

}
