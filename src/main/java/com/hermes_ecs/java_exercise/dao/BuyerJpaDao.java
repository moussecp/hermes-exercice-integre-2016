package com.hermes_ecs.java_exercise.dao;

import org.springframework.stereotype.Repository;

import com.hermes_ecs.java_exercise.domain.Buyer;

@Repository
public class BuyerJpaDao extends AbstractJpaDao<Long, Buyer> implements BuyerDao {

	BuyerJpaDao() {
		super(Buyer.class);
	}
	
}
