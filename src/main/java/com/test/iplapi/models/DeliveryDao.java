package com.test.iplapi.models;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Transactional
public interface DeliveryDao extends CrudRepository<Delivery, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM deliveries WHERE match_id = :match AND inning = :inning AND over = :over AND ball = :ball")
	public Delivery getDelivery(@Param("match") Integer match, @Param("inning") Integer inning,
			@Param("over") Integer over, @Param("ball") Integer ball);

}
