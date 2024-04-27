package ru.teamscore.dictionary.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.teamscore.dictionary.dto.WordDto;
import ru.teamscore.dictionary.services.WordService;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/dictionary")
public class WordController {
    @Autowired
    private final WordService wordService;

    @GetMapping
    public ResponseEntity<Iterable<WordDto>> getDictionary() {
        List<WordDto> words = wordService.getDictionary();
        return new ResponseEntity<Iterable<WordDto>>(words,
                words == null ? HttpStatus.NOT_FOUND : HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WordDto> getWord(@PathVariable("id") long id) {
        WordDto word = wordService.getWord(id);
        return new ResponseEntity<WordDto>(word,
                word == null ? HttpStatus.NOT_FOUND : HttpStatus.CREATED);
    }

//    @GetMapping("/synonyms/{id}")
//    public ResponseEntity<Iterable<WordDto>> getSynonyms(@PathVariable("id") long id) {
//        WordDto word = wordService.getSynonyms(id);
//        return new ResponseEntity<WordDto>(word,
//                word == null ? HttpStatus.NOT_FOUND : HttpStatus.CREATED);
//    }
}
