package ru.teamscore.dictionary.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.teamscore.dictionary.dto.DefinitionDto;
import ru.teamscore.dictionary.dto.WordDto;
import ru.teamscore.dictionary.services.WordService;

import java.util.Iterator;
import java.util.List;

@RestController
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
}
