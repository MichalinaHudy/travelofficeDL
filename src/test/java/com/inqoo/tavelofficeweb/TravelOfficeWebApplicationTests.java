package com.inqoo.tavelofficeweb;

import com.inqoo.tavelofficeweb.model.Customer;
import com.inqoo.tavelofficeweb.model.CustomerNameDetails;
import com.inqoo.tavelofficeweb.model.Trip;
import com.inqoo.tavelofficeweb.repository.CustomerJpaRepository;
import com.inqoo.tavelofficeweb.repository.TripJpaRepository;
import com.inqoo.tavelofficeweb.service.CustomerService;
import com.inqoo.tavelofficeweb.service.TripService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.List;
import java.util.Optional;

//@SpringBootTest
class TravelOfficeWebApplicationTests {

	private TripService tripService;

	private Trip tosave = new Trip();
	private Trip tosave2 = new Trip();
	@BeforeEach
	public void initDependencies () {
		tosave.setDestination("Berlin");
		tosave.setPriceEur(1500);
		tosave2.setDestination("Berlin2");
		tosave2.setPriceEur(1500);

		TripJpaRepository mockedTripRepository =
				Mockito.mock(TripJpaRepository.class);

//		Mockito.when(mockedTripRepository.save(tosave))
//				.thenReturn(tosave);

		Mockito.when(mockedTripRepository.findAll())
				.thenReturn(List.of(tosave,tosave2));

		tripService = new TripService(mockedTripRepository);

	}
	@Test
	void saveTripShouldBeReturnedByFindAll(){

		tripService.saveTrip(tosave);
		List<Trip> allTrips = tripService.getAllTrips("Berlin");
		System.out.println(allTrips);
		org.junit.jupiter.api.Assertions.assertEquals(2, allTrips.size());
		Optional<Trip> maybyeBerlin = allTrips.stream().filter(t ->t.getDestination().equals("Berlin")).findFirst();
		Assertions.assertThat(maybyeBerlin);
	}



	private CustomerService customerService;

	Customer cus1 = new Customer();
	Customer cus3 = new Customer();
	CustomerNameDetails cus2 = new CustomerNameDetails();
	CustomerNameDetails cus4 = new CustomerNameDetails();

	@BeforeEach
	public void setdata () {
		cus2.setFirstName("Dawid");
		cus2.setLastName("Lyka");
		cus4.setFirstName("Dawid");
		cus4.setLastName("Kowalski");
		cus1.setCustomerNameDetails(cus2);
		cus1.setCustomerNameDetails(cus2);
		cus3.setCustomerNameDetails(cus4);
		cus3.setCustomerNameDetails(cus4);


		CustomerJpaRepository mockedCustomerRepository =
				Mockito.mock(CustomerJpaRepository.class);

////		Mockito.when(mockedCustomerRepository.save(cus2))
////				.thenReturn(cus2);
//
		Mockito.when(mockedCustomerRepository.findAll())
				.thenReturn(List.of(cus1,cus3));
//
		customerService = new CustomerService(mockedCustomerRepository);

	}
	@Test
	void saveCustomertoFindAll(){

		customerService.saveCustomer(cus1);
		customerService.saveCustomer(cus3);

		List<Customer> allCustomers = customerService.getAllCust();
		System.out.println(allCustomers);
		org.junit.jupiter.api.Assertions.assertEquals(1, allCustomers.size());
		Optional<Customer> maybyeDawid = allCustomers.stream().filter(c ->c.getCustomerNameDetails().getFirstName().equals("dawid")).findFirst();
		Assertions.assertThat(maybyeDawid);
	}

}
