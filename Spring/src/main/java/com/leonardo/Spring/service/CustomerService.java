package com.leonardo.Spring.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.Spring.domain.Customer;
import com.leonardo.Spring.error.NotFoundException;
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

        if (customerRepository.existsById(id)) {
            return customerRepository.findById(id).get();
        } else {
            throw new NotFoundException("Couldn't Find Customer! ID: " + id);
        }
    }

    // Save Customer
    public Void saveCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    // Update Customer
    public void updateCustomer(Customer customer) {

        if (customerRepository.existsById(customer.getId())) {
            customerRepository.saveAndFlush(customer);
        } else {
            throw new NotFoundException("Couldn't Find Customer! ID: " + id + " Exception: " + e);
        }
    }

    // Delete Customer
    public void deleteCustomerById(Long id) {

        customerRepository.deleteById(id);
    }
}
