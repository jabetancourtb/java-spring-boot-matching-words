package com.matching.words.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matching.words.dto.LettersDTO;
import com.matching.words.service.DictionaryService;

@RestController
@RequestMapping("dictionary")
public class DictionaryController {

	private final DictionaryService dictionaryService;
	
	@Autowired
	public DictionaryController(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
	
	@PostMapping
	public ResponseEntity<List<String>> matchingWords(@RequestBody LettersDTO letters) {
		List<String> matchingWords = null;
		
		try {
			matchingWords = dictionaryService.matchingWords(letters.getLetters());
			return new ResponseEntity<>(matchingWords, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(matchingWords, HttpStatus.INTERNAL_SERVER_ERROR); 
		}	
		
	}
}
