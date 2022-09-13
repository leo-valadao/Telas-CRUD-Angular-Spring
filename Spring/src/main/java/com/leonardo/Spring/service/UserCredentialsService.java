package com.leonardo.Spring.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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
        public Optional<UserCredentials> findUserCredentialsById(Long id) {
            Optional<UserCredentials> userCredentials = userCredentialsRepository.findById(id);
            if (userCredentials.isPresent()) {
                return userCredentials;
            } else {
                throw new EntityNotFoundException("UserCredentials Not Found! ID: " + id);
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
