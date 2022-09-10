package com.leonardo.Spring.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonardo.Spring.domain.Customer;
import com.leonardo.Spring.service.CustomerService;

@RestController
@RequestMapping(path = "/api/customer")
public class CustomerResource {

    // Objetcs
    @Autowired
    private CustomerService customerService;

    // API's
    // Get All Customer(s)
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<List<Customer>>(customerService.findAllCustomers(), HttpStatus.OK);
    }

    // Get Customer by ID
    @GetMapping
    @RequestMapping(value = "/{id}")
    public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable("id") Long id) {
        Optional<Customer> customer = customerService.findCustomerById(id);
        if (customer.isPresent()) {
            return new ResponseEntity<Optional<Customer>>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<Optional<Customer>>(HttpStatus.NOT_FOUND);
        }
    }

    // Save Customer
    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }

    // Update Customer
    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        Optional<Customer> oldCustomer = customerService.findCustomerById(customer.getId());
        if (oldCustomer.isPresent()) {
            return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.OK);
        } else {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Customer
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id) {
        try {
            customerService.deleteCustomerById(id);
            return new ResponseEntity<String>("Customer Successfully Deleted! ID: " + id, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<String>("Failed to Delete Customer Due to Data Integrity Violation! ID: " + id,
                    HttpStatus.BAD_REQUEST);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<String>("Failed to Delete Customer Due to Not Finding It! ID: " + id,
                    HttpStatus.NOT_FOUND);
        }
    }
}
