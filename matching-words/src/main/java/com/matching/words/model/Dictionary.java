package com.matching.words.model;

import java.util.List;

public class Dictionary {
	
	public static Dictionary instance;
	private List<String> words;
	
	private Dictionary() {
		
	}
	
	public static Dictionary getInstance() {
		if(instance == null) {
			instance = new Dictionary();
		}
		
		return instance;
	}
	
	public void setWords(List<String> words) {
		if(this.words == null) {
			this.words = words;
		}
	}
	
	public List<String> getWords() {
		return words;
	}
}
