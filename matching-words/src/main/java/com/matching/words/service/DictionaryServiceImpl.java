package com.matching.words.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matching.words.model.Dictionary;
import com.matching.words.repository.DictionaryRepository;

@Service
public class DictionaryServiceImpl implements DictionaryService {
	
	private final DictionaryRepository dictionaryRepository;
	
	@Autowired
	public DictionaryServiceImpl(DictionaryRepository dictionaryRepository) {
		this.dictionaryRepository = dictionaryRepository;
	}

	/*This task must be run only once. 
	 *For this, the singleton pattern was implemented*/
	@Override
	public List<String> wordsFromDictionary() {	
		Dictionary dictionary = Dictionary.getInstance();
		
		dictionary.setWords(dictionaryRepository.findAllWords());
		
		return dictionary.getWords();
	}
	
	
	@Override
	public List<String> matchingWords(List<String> letters) {
		List<String> wordsFromDictionary = wordsFromDictionary();
		
		List<String> matchingWords = new ArrayList<>();
		
		for(String wordFromDictionary: wordsFromDictionary) {
			
			StringBuilder newWord = new StringBuilder();
			
			for(int i=0; i<wordFromDictionary.length(); i++) {
				
				String wordLetter = wordFromDictionary.toUpperCase().substring(i, i+1);
				
				boolean lettersCotainsWordLetter = letters.contains(wordLetter);
			
				boolean newWordContainsWordLetter = newWord.toString().contains(wordLetter);
				
				if(lettersCotainsWordLetter && !newWordContainsWordLetter) {
					newWord.append(wordLetter.toLowerCase());
				}
				else {
					break;
				}
			}
			
			if(newWord.toString().equals(wordFromDictionary)) {
				matchingWords.add(newWord.toString());	
			}
		}
		
		return matchingWords;
	}
	

}
