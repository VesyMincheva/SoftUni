package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.AddWordDTO;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordsRepository;
import com.dictionaryapp.service.LanguageService;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.util.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WordServiceImpl implements WordService {

    private final WordsRepository wordsRepository;
    private final LoggedUser loggedUser;
    private final UserRepository userRepository;

    private final LanguageService languageService;


    public WordServiceImpl(WordsRepository wordsRepository,
                           LoggedUser loggedUser,
                           UserRepository userRepository, LanguageService languageService) {
        this.wordsRepository = wordsRepository;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
        this.languageService = languageService;
    }

    @Override
    public boolean create(AddWordDTO addWordDto) {

        Optional<Word> wordByTerm = wordsRepository.findWordByTerm(addWordDto.getTerm());
        if (wordByTerm.isPresent()){
            return false;
        }


        Optional<User> createdBy = this.userRepository.findUserById(this.loggedUser.getId());

        Language language = this.languageService.findLanguage(addWordDto.getLanguage());

        Word word = new Word();
        word.setTerm(addWordDto.getTerm());
        word.setTranslation(addWordDto.getTranslation());
        word.setExample(addWordDto.getExample());
        word.setInputDate(addWordDto.getInputDate());
        word.setLanguage(language);
        createdBy.ifPresent(word::setAddedBy);


        this.wordsRepository.save(word);

        return true;
    }


}
