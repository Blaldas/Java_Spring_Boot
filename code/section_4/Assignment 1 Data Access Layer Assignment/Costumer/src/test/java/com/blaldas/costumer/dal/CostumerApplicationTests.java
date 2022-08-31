package com.blaldas.costumer.dal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blaldas.costumer.dal.entities.Costumer;
import com.blaldas.costumer.dal.repos.CostumerRepository;

@SpringBootTest
class CostumerApplicationTests {
	
	@Autowired
	private CostumerRepository repo;
	
	@Test
	void testSetNewCostumer() {
		Costumer costumer = new Costumer();
		costumer.setEmail("mahbva@das.com");
		costumer.setName("João Lacerda");
		
		System.out.println(costumer);
		
		repo.save(costumer);	
	}

}
