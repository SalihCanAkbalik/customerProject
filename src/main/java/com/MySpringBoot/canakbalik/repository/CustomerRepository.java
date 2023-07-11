package com.MySpringBoot.canakbalik.repository;

import com.MySpringBoot.canakbalik.model.Customer;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, Integer>{}

