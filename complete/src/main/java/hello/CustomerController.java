package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import repository.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired 
	private CustomerRepository customerRepository;
	
	@RequestMapping("/customers")
	public List<Customer> customers() {
		return  customerRepository.findAll();
	}
	
	@RequestMapping("/customers/{id}")
	public Customer customer(@PathVariable String id){
		return customerRepository.findOne(id);
	}
	
	
	
}
