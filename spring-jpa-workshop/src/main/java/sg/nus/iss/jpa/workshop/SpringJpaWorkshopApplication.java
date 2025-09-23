package sg.nus.iss.jpa.workshop;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.nus.iss.jpa.workshop.model.Address;
import sg.nus.iss.jpa.workshop.model.Customer;
import sg.nus.iss.jpa.workshop.repository.AddressRepository;
import sg.nus.iss.jpa.workshop.repository.CustomerRepository;

@SpringBootApplication
public class SpringJpaWorkshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaWorkshopApplication.class, args);
	}

	@Bean
  CommandLineRunner commandLineRun(AddressRepository addressRepo, CustomerRepository customerRepo) {
    return args -> {
      // Test Address repository
      System.out.println("---- Create some addresses");
      Address nus = addressRepo.save(new Address("21 Lower Kent Ridge Rd", "Singapore", "SG"));
      Address ntu = addressRepo.save(new Address("50 Nanyang Ave", "Singapore", "SG"));
      Address stanford = addressRepo.save(new Address("450 Serra Mall, Stanford", "California", "USA"));
      Address oxford = addressRepo.save(new Address("OX1 2JD", "Oxford", "UK"));
      
      System.out.println("---- Find all addresses");
      List<Address> myAddresses = addressRepo.findAll();
      myAddresses.forEach(myAddress -> System.out.println(myAddress));
      
      System.out.println("---- Find addresses by country SG");
      myAddresses = addressRepo.findByCountry("SG");
      myAddresses.forEach(myAddress -> System.out.println(myAddress));
      

      System.out.println("---- Create some customers");
      Customer emma = new Customer("Emma", "emma@example.com");
      Customer robert = new Customer("Robert", "robert@example.com");
      Customer jewel = new Customer("Jewel", "jewel@example.com");
      
      emma.setAddresses(Arrays.asList(nus, stanford));
      robert.setAddresses(Arrays.asList(oxford));
      jewel.setAddresses(Arrays.asList(ntu));
 
      customerRepo.save(emma);
      customerRepo.save(robert);
      customerRepo.save(jewel);
      
      System.out.println("---- Find all customers");
      List<Customer> myCustomers = customerRepo.findAll();
      myCustomers.forEach(myCustomer -> System.out.println(myCustomer));
      
      System.out.println("---- Find all customers in country SG");
      myCustomers = customerRepo.findByAddressCountry("SG");
      myCustomers.forEach(myCustomer -> System.out.println(myCustomer));

    };
  }
}
