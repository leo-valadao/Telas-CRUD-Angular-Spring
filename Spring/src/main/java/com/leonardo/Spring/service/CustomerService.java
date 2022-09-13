package com.leonardo.Spring.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.Spring.domain.Customer;
import com.leonardo.Spring.repository.CustomerRepository;

@Service
public class CustomerService {

    // Objetcs
    // Customer Repository
    @Autowired
    private CustomerRepository customerRepository;

    // Methods
    // Get All Customer(s)
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    // Get Customer by ID
    public Optional<Customer> findCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customer;
        } else {
            throw new EntityNotFoundException("Customer Not Found! ID: " + id);
        }
    }

    // Save Customer
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Delete Customer
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer findCustomerByEmail(String email) {
        return null;
    }
}
