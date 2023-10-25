package com.dictionaryapp.service;


import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.enums.LanguageName;

public interface LanguageService {

    public Language findLanguage(LanguageName languageName);
}
