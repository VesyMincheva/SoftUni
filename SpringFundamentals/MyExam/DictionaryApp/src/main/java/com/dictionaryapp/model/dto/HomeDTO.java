package com.dictionaryapp.model.dto;

import com.dictionaryapp.model.entity.Word;

import java.util.List;

public class HomeDTO {
    private List<Word> germanWords;
    private List<Word> spanishWords;
    private List<Word> frenchWords;
    private List<Word> italianWords;
    private List<Word> allWords;

    public HomeDTO() {
    }

    public List<Word> getGermanWords() {
        return germanWords;
    }

    public void setGermanWords(List<Word> germanWords) {
        this.germanWords = germanWords;
    }

    public List<Word> getSpanishWords() {
        return spanishWords;
    }

    public void setSpanishWords(List<Word> spanishWords) {
        this.spanishWords = spanishWords;
    }

    public List<Word> getFrenchWords() {
        return frenchWords;
    }

    public void setFrenchWords(List<Word> frenchWords) {
        this.frenchWords = frenchWords;
    }

    public List<Word> getItalianWords() {
        return italianWords;
    }

    public void setItalianWords(List<Word> italianWords) {
        this.italianWords = italianWords;
    }

    public List<Word> getAllWords() {
        return allWords;
    }

    public void setAllWords(List<Word> allWords) {
        this.allWords = allWords;
    }
}
