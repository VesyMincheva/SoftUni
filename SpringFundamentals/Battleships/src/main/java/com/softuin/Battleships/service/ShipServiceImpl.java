package com.softuin.Battleships.service;

import com.softuin.Battleships.model.dto.CreateShipDTO;
import com.softuin.Battleships.model.entity.Category;
import com.softuin.Battleships.model.entity.Ship;
import com.softuin.Battleships.model.entity.User;
import com.softuin.Battleships.model.enums.CategoryEnum;
import com.softuin.Battleships.repository.CategoryRepository;
import com.softuin.Battleships.repository.ShipRepository;
import com.softuin.Battleships.repository.UserRepository;
import com.softuin.Battleships.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;
    private final LoggedUser loggedUser;
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;

    public ShipServiceImpl(ShipRepository shipRepository, LoggedUser loggedUser, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.shipRepository = shipRepository;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean createShip(CreateShipDTO createShipDTO) {

        Optional<Ship> shipByName = shipRepository.findShipByName(createShipDTO.getName());
        if (shipByName.isPresent()){
            return false;
        }

        CategoryEnum type = switch (createShipDTO.getCategory()){
            case 0 -> CategoryEnum.BATTLE;
            case 1 -> CategoryEnum.CARGO;
            case 2 -> CategoryEnum.PATROL;
            default -> CategoryEnum.BATTLE;
        };

        Ship ship = new Ship();
        Optional<User> owner = this.userRepository.findUserById(loggedUser.getId());
        Category category = this.categoryRepository.findByName(type);

        ship.setName(createShipDTO.getName());
        ship.setPower(createShipDTO.getPower());
        ship.setHealth(createShipDTO.getHealth());
        ship.setCreated(createShipDTO.getCreated());
        ship.setCategory(category);
        ship.setUser(owner.get());

        this.shipRepository.save(ship);
        return true;
    }
}
