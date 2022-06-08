package com.tecsup.petclinic.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;


@SpringBootTest
public class OwnerServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTest.class);

	
	@Autowired
	private OwnerService ownerService;
	
	@Test
	public void testCreateOwner() {
		String FIRST_NAME = "Carlos";
		String LAST_NAME = "Mendoza";
		String CITY  = "Trujillo";
		
		Owner owner =new Owner("Carlos","Mendoza","Trujillo");
		Owner ownerCreated = ownerService.create(owner);
		logger.info("Owner creado : "+ownerCreated);
		assertThat(ownerCreated.getId(), notNullValue());
		assertThat(ownerCreated.getFirst_name(), is(FIRST_NAME));
		assertThat(ownerCreated.getLast_name(), is(LAST_NAME));
		assertThat(ownerCreated.getCity(), is(CITY));
	}
	
}