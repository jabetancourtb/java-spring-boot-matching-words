package com.word.combination;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import com.matching.words.controllers.DictionaryController;

@SpringBootTest
class MatchingWordsApplicationTests {
	                            
	private MockMvc mockMvc; 
	private final DictionaryController dictionaryController;
	
	@Autowired
	public MatchingWordsApplicationTests(MockMvc mockMvc, DictionaryController dictionaryController) {
		this.mockMvc = mockMvc;
		this.dictionaryController = dictionaryController;
	}

	@Test
	void contextLoads() throws Exception {
		assertThat(dictionaryController).isNotNull();
	}
	
	@Test
	public void firstTest() throws Exception {		
		String[] letters = new String[] {"T", "J", "E", "U", "I", "N", "G", "R", "T", "S", "D", "A"};
		
		this.mockMvc.perform(post("/dictionary", Arrays.asList(letters)))
		.andExpect(status().isOk())
		.andExpect(null);
	}
}
