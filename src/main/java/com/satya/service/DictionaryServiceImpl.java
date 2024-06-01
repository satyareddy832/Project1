package com.satya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.satya.dao.IDictionaryRepo;
import com.satya.model.dictionary;


@Service
public class DictionaryServiceImpl implements IDictionaryService {

	@Autowired
	private IDictionaryRepo repo;
	
	@Override
	public List<dictionary> fetchAllData() 
	{
		return repo.findAll();
	}
	
	@Override
	public void insertRecordIntoDictionary(dictionary dict) {
		repo.save(dict);
	}

}
