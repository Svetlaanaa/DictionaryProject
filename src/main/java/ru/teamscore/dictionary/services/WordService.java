package ru.teamscore.dictionary.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.teamscore.dictionary.converters.ConverterWord;
import ru.teamscore.dictionary.dto.WordDto;
import ru.teamscore.dictionary.model.entities.Word;
import ru.teamscore.dictionary.repositories.WordRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WordService {
    @Autowired
    private final WordRepository wordRepository;

    private final ConverterWord converterWord;

    public List<WordDto> getDictionary() {
       List<Word> words = wordRepository.findAll();
       List<WordDto> wordsDto = new ArrayList<>();
       for(Word word : words){
           wordsDto.add(converterWord.toDto(word));
       }
       return wordsDto;
    }
}
