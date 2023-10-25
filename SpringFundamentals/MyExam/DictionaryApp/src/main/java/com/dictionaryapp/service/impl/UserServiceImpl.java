package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.LoginDTO;
import com.dictionaryapp.model.dto.UserRegistrationDTO;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.util.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    public UserServiceImpl(UserRepository userRepository, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }
    public boolean register(UserRegistrationDTO registrationDTO) {
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

        this.loggedUser.login(user.get());

        return true;
    }

    public void logout() {
        loggedUser.logout();
    }

    public Long getLoggedUserId (){
        return this.loggedUser.getId();
    }
}
