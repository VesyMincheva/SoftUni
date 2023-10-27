package com.softuin.Battleships.service;

import com.softuin.Battleships.model.dto.LoginDTO;
import com.softuin.Battleships.model.dto.RegistrationDTO;
import com.softuin.Battleships.model.entity.User;
import com.softuin.Battleships.repository.UserRepository;
import com.softuin.Battleships.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    public AuthenticationServiceImpl(UserRepository userRepository, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    @Override
    public boolean register(RegistrationDTO registrationDTO) {
        // password == confirmPassword
        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())){
            return false;
        }

        //duplicate email
        Optional<User> userByEmail = userRepository.findUserByEmail(registrationDTO.getEmail());
        if (userByEmail.isPresent()){
            return false;
        }

        //duplicate user
        Optional<User> userByUsername = userRepository.findUserByUsername(registrationDTO.getUsername());
        if (userByUsername.isPresent()){
            return false;
        }

        User user = new User();
        user.setUsername(registrationDTO.getUsername());
        user.setFullName(registrationDTO.getFullName());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword());
        this.userRepository.save(user);

        return true;
    }

    public boolean login(LoginDTO loginDTO) {
        Optional<User> user = userRepository
                .findUserByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
        if (user.isEmpty()){
            return false;
        }

        // actual login
        this.loggedUser.login(user.get());

        return true;
    }
}
