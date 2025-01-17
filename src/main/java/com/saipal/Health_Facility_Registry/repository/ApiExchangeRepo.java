package com.saipal.Health_Facility_Registry.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saipal.Health_Facility_Registry.entity.ApiExchange;


@Repository
public interface ApiExchangeRepo extends JpaRepository<ApiExchange, Integer> {

	@Modifying(clearAutomatically = true) @Transactional
	 @Query(value = "insert into api_exchange(hfid,action) VALUES (:lid,:s)", nativeQuery = true)
	void addApiData(int lid, String s);

	 @Query(value="SELECT a.* FROM api_exchange a LEFT JOIN hfregistry h ON a.hfid=h.id where a.id>?1",nativeQuery=true)
	  List<ApiExchange> getLatests(int lastid);
	 
	 @Query(value="SELECT a.* FROM api_exchange a LEFT JOIN hfregistry h ON a.hfid=h.id where date(a.created_at)>=date(?1)",nativeQuery=true)
	  List<ApiExchange> getLatestHfs(String date);
}
