package com.leonardo.Spring.resource;

import java.util.List;

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

import com.leonardo.Spring.domain.UserCredentials;
import com.leonardo.Spring.service.UserCredentialsService;

@RestController
@RequestMapping(path = "/api/v1/usercredentials")
public class UserCredentialsResource {

    // Objetcs
    @Autowired
    private UserCredentialsService userCredentialsService;

    // API's
    // Get All User's Credential(s)
    @GetMapping
    public ResponseEntity<List<UserCredentials>> getAllUserCredentialss() {
        return new ResponseEntity<List<UserCredentials>>(userCredentialsService.findAllUserCredentials(),
                HttpStatus.OK);
    }

    // Get User's Credential by ID
    @GetMapping
    @RequestMapping(value = "/{id}")
    public ResponseEntity<UserCredentials> getUserCredentialsById(@PathVariable("id") Long id) {
        UserCredentials userCredentials = userCredentialsService.findUserCredentialsById(id);
        if (userCredentials != null) {
            return new ResponseEntity<UserCredentials>(userCredentials, HttpStatus.OK);
        } else {
            return new ResponseEntity<UserCredentials>(HttpStatus.NOT_FOUND);
        }
    }

    // Save User's Credentials
    @PostMapping
    public ResponseEntity<UserCredentials> addUserCredentials(@RequestBody UserCredentials userCredentials) {
        return new ResponseEntity<UserCredentials>(userCredentialsService.saveUserCredentials(userCredentials),
                HttpStatus.CREATED);
    }

    // Update User's Credentials
    @PutMapping
    public ResponseEntity<UserCredentials> updateUserCredentials(@RequestBody UserCredentials userCredentials) {
        UserCredentials oldUserCredentials = userCredentialsService
                .findUserCredentialsById(userCredentials.getId());
        if (oldUserCredentials != null) {
            return new ResponseEntity<UserCredentials>(userCredentialsService.saveUserCredentials(userCredentials),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<UserCredentials>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete User's Credentials
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteUserCredentials(@PathVariable("id") Long id) {
        try {
            userCredentialsService.deleteUserCredentialsById(id);
            return new ResponseEntity<String>("User's Credentials Successfully Deleted! ID: " + id, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<String>(
                    "Failed to Delete User's Credentials Due to Data Integrity Violation! ID: " + id,
                    HttpStatus.BAD_REQUEST);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<String>("Failed to Delete User's Credentials Due to Not Finding It! ID: " + id,
                    HttpStatus.NOT_FOUND);
        }
    }
}
