package com.leonardo.Spring.service;

import java.util.List;
import java.util.NoSuchElementException;

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
    public Customer findCustomerById(Long id) {
        try {
            return customerRepository.findById(id).get();    
        } catch (Exception e) {
            throw new NoSuchElementException("Couldn't Find Customer! ID: " + id+" Exception: " +e);
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
