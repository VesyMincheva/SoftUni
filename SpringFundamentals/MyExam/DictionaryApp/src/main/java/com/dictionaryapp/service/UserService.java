package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.LoginDTO;
import com.dictionaryapp.model.dto.UserRegistrationDTO;

public interface UserService {

    public boolean register(UserRegistrationDTO registrationDTO);

    public boolean login(LoginDTO loginDTO);
    public void logout();

    public Long getLoggedUserId ();
}
