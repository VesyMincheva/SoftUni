package com.softuin.Battleships.repository;

import com.softuin.Battleships.model.entity.Category;
import com.softuin.Battleships.model.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(CategoryEnum type);
}
