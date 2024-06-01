package com.satya.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.satya.model.dictionary;


public interface IDictionaryService {
	
	public List<dictionary> fetchAllData();
	public void insertRecordIntoDictionary(dictionary dict);

}
