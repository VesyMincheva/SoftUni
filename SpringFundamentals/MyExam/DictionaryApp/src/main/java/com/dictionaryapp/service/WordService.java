package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.AddWordDTO;

public interface WordService {
    boolean create(AddWordDTO addWordDto);

}
