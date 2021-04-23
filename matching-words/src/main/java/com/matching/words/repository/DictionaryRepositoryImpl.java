package com.matching.words.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DictionaryRepositoryImpl implements DictionaryRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public DictionaryRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<String> findAllWords() {
		List<String> words = null;
		String query = "SELECT palabra FROM palabras LIMIT 100000";
		
		try {
			words = jdbcTemplate.query(query, new Object[] {}, (resultSet, rowNumber) -> {
				return resultSet.getString(1);
			});
		}
		catch(EmptyResultDataAccessException exception) {
			throw new RuntimeException();
		}
		
		return words;
	}

}
