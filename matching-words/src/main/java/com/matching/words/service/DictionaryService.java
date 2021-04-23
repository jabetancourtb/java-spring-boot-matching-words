package com.matching.words.service;

import java.util.List;

public interface DictionaryService {
	
	public List<String> wordsFromDictionary();
	
	public List<String> matchingWords(List<String> letters);
}
