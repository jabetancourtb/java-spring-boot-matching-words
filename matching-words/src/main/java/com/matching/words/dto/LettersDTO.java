package com.matching.words.dto;

import java.util.List;

public class LettersDTO {

	private List<String> letters;
	
	public LettersDTO(List<String> letters) {
		this.letters = letters;
	}
	
	public LettersDTO() {
		
	}
	
	public List<String> getLetters() {
		return letters;
	}
}
