package com.MySpringBoot.canakbalik.controller;

import com.MySpringBoot.canakbalik.model.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.MySpringBoot.canakbalik.repository.CustomerRepository;

import java.util.Optional;
@RestController
@RequestMapping("/customer")
public class customerController {
    @Autowired
    private final CustomerRepository customerRepository;

    public customerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/add")  //add customers
    public Customer addNewCustomer(@RequestBody Customer newCustomer){
        Customer user = new Customer();
        user.setName(newCustomer.getName());
        user.setEmail(newCustomer.getEmail());
        user.setBudget(newCustomer.getBudget());
        customerRepository.save(user);
        return user;
    }

    @GetMapping("/view/all") //view all customers
    public @ResponseBody Iterable<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("view/{id}") // view customer with id
    public Optional<Customer> getCustomer(@PathVariable Integer id) {
        return customerRepository.findById(id);
    }

    @PostMapping("/edit/{id}") // edit already exist customer
    public Optional<Customer> update(@RequestBody Customer updateCustomer, @PathVariable Integer id){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (Customer.isPresent()) {
            Customer customer = optionalCustomer.get();
            BeanUtils.copyProperties(updateCustomer, customer, "id", "name", "email");
            return Optional.of(customerRepository.save(customer));
        } else {
            throw new IllegalArgumentException("Address not found with id: " + id);
        }
        }

    @DeleteMapping("delete/{id}") // delete customer
    public String delete(@PathVariable("id")Integer id) {
        customerRepository.deleteById(id);
        return "Customer has been successfully deleted!";
    }

}
