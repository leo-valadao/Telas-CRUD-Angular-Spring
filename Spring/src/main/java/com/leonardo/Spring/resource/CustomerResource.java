package com.leonardo.Spring.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(path = "/api/v1/customer")
public class CustomerResource {

    // Objetcs
    @Autowired
    private CustomerService customerService;

    // API's
    // Get All Customer(s)
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {

        List<Customer> customers = customerService.findAllCustomers();

        if (!customers.isEmpty()) {
            return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
        }
    }

    // Get Customer by ID
    @GetMapping
    @RequestMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {

        Customer customer = customerService.findCustomerById(id);

        if (customer != null) {
            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
        }
    }

    // Save Customer
    @PostMapping
    public ResponseEntity<Void> addCustomer(@RequestBody @Valid Customer customer) {

        customerService.saveCustomer(customer);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    // Update Customer
    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {

        Customer oldCustomer = customerService.findCustomerById(customer.getId());

        if (oldCustomer != null) {
            customerService.updateCustomer(customer);
            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Customer
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id) {

        Customer oldCustomer = customerService.findCustomerById(id);

        if (oldCustomer != null) {
            customerService.deleteCustomerById(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
