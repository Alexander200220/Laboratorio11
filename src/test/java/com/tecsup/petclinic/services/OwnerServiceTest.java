package com.tecsup.petclinic.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

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
	public void testDeleteOwner() {
		String FIRST_NAME="Eduardo";
		String LAST_NAME="Rodriquez";
		String ADDRESS="2693 Commerce St.";
		String CITY="McFarland";
		String TELEPHONE="6085558763";
		
		Owner owner = new Owner(FIRST_NAME, LAST_NAME, ADDRESS, CITY, TELEPHONE);
		owner = ownerService.create(owner);
		logger.info(""+ owner);
		
		try {
			ownerService.delete(owner.getId());
		}catch (OwnerNotFoundException e) {
			assertThat(e.getMessage(), false);
		}
		
		try {
			ownerService.findById(owner.getId());
			assertThat(true, is(false));
		}catch (OwnerNotFoundException e) {
			assertThat(true, is(true));
		}
	}
}
