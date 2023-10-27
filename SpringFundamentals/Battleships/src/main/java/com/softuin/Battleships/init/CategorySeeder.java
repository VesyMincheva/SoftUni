package com.softuin.Battleships.init;

import com.softuin.Battleships.model.entity.Category;
import com.softuin.Battleships.model.enums.CategoryEnum;
import com.softuin.Battleships.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategorySeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;


    public CategorySeeder(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.categoryRepository.count() == 0){
            List<Category> categories = Arrays.stream(CategoryEnum.values())
                    .map(Category::new)
                    .toList();

        this.categoryRepository.saveAll(categories);
        }
    }
}
