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

        List<UserCredentials> userCredentialss = userCredentialsService.findAllUserCredentials();

        if (!userCredentialss.isEmpty()) {
            return new ResponseEntity<List<UserCredentials>>(userCredentialss, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<UserCredentials>>(HttpStatus.NO_CONTENT);
        }
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
    public ResponseEntity<Void> addUserCredentials(@RequestBody @Valid UserCredentials userCredentials) {

        userCredentialsService.saveUserCredentials(userCredentials);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    // Update User's Credentials
    @PutMapping
    public ResponseEntity<UserCredentials> updateUserCredentials(@RequestBody UserCredentials userCredentials) {

        UserCredentials oldUserCredentials = userCredentialsService.findUserCredentialsById(userCredentials.getId());

        if (oldUserCredentials != null) {
            userCredentialsService.saveUserCredentials(userCredentials);
            return new ResponseEntity<UserCredentials>(userCredentials, HttpStatus.OK);
        } else {
            return new ResponseEntity<UserCredentials>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete User's Credentials
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUserCredentials(@PathVariable("id") Long id) {

        UserCredentials oldUserCredentials = userCredentialsService.findUserCredentialsById(id);

        if (oldUserCredentials != null) {
            userCredentialsService.deleteUserCredentialsById(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
