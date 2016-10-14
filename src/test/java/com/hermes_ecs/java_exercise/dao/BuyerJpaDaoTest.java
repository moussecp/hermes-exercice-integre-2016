package com.hermes_ecs.java_exercise.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.hermes_ecs.java_exercise.domain.Buyer;

public class BuyerJpaDaoTest extends AbstractJpaDaoTest<Long, Buyer> {
    
    private BuyerDao buyerDao = new BuyerDao();

    @Override
    protected BuyerDao getDao() {
        return buyerDao;
    }

    @Override
    protected Buyer buildItem(int i) {
        return new Buyer("Luke" + i, "Skywalker", "Tatouine");
    }
}
