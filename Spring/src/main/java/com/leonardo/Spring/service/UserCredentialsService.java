package com.leonardo.Spring.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.Spring.domain.UserCredentials;
import com.leonardo.Spring.repository.UserCredentialsRepository;

@Service
public class UserCredentialsService {

    // Objetcs
    // User's Credentials Repository
    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    // Methods
    // Get All Users's Credentials
    public List<UserCredentials> findAllUserCredentials() {
        return userCredentialsRepository.findAll();
    }

        // Get User's Credentials by ID
        public UserCredentials findUserCredentialsById(Long id) {
            try {
                return userCredentialsRepository.findById(id).get();
            } catch (Exception e) {
                throw new NoSuchElementException("Couldn't Find User's Credentials! ID: " + id + " Exception: " + e);
            }
        }
    
        // Save User's Credentials
        public UserCredentials saveUserCredentials(UserCredentials userCredentials) {
            return userCredentialsRepository.save(userCredentials);
        }
    
        // Delete User's Credentials
        public void deleteUserCredentialsById(Long id) {
            userCredentialsRepository.deleteById(id);
        }
    
        public UserCredentials findUserCredentialsByEmail(String email) {
            return null;
        }

        // Get User's Credentials by Username
        // @Override
        // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //     try {
        //         UserCredentials userCredentials = userCredentialsRepository.findByUsename(username);
        //         return new User(userCredentials.getUsername(), userCredentials.getPassword(), new ArrayList<>());
        //     } catch (Exception e) {
        //         throw new UsernameNotFoundException(username);
        //     }            
        // }
}
