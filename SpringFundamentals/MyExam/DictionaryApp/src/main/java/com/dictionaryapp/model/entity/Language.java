package com.dictionaryapp.model.entity;

import com.dictionaryapp.model.enums.LanguageName;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "languages")
public class Language extends BaseEntity{

    @Column(name = "name", unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private LanguageName name;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "language")
    private List<Word> words;

    public Language() {
        this.words = new ArrayList<>();
    }

    public Language(LanguageName languageName) {
        this.name = languageName;
        this.description = languageName.getDescription();
        this.words = new ArrayList<>();
    }

    public LanguageName getName() {
        return name;
    }

    public void setName(LanguageName name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
}
