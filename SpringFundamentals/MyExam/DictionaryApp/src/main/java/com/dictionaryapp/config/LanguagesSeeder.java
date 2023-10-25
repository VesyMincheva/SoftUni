package com.dictionaryapp.config;

import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.enums.LanguageName;
import com.dictionaryapp.repo.LanguageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LanguagesSeeder implements CommandLineRunner {

    private final LanguageRepository languageRepository;

    public LanguagesSeeder(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (this.languageRepository.count() == 0){
            List<Language> languages = Arrays.stream(LanguageName.values())
                    .map(Language::new).collect(Collectors.toList());

            this.languageRepository.saveAll(languages);
        }
    }
}
