package com.softuin.Battleships.service;

import com.softuin.Battleships.model.dto.LoginDTO;
import com.softuin.Battleships.model.dto.RegistrationDTO;

public interface AuthenticationService {

    public boolean register(RegistrationDTO registrationDTO);

    public boolean login(LoginDTO loginDTO);
}
