package com.satya.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satya.model.dictionary;
import com.satya.service.IDictionaryService;
import com.satya.trie.Trie;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class DictionaryController {
	@Autowired
	private IDictionaryService dictService;
	
	@Autowired
	private Trie trieObj;
	
	@GetMapping("/helper")
	public String Helper() {
		System.out.println("Iam in Helper Function");
		List<dictionary> words;
		System.out.println();
		words=dictService.fetchAllData();
		for(dictionary dict :words) {
			trieObj.insertWord(dict.getWord(), dict.getMeaning(), "", dict.getPos(), dict.getExample());
		}
		System.out.println("the list of fetched values are ");
		System.out.println(words);
		
		System.out.println("the add "+trieObj);
		
		System.out.println("this is came form trie "+trieObj.getAllWordsAndMeanings());
		
		return "HomePage";
		
	}
	
	@GetMapping("/helper2")
	public String Helper2() {
		ArrayList<dictionary> dictionaryList = new ArrayList<>();
		

        for (dictionary word : dictionaryList) {
        	dictService.insertRecordIntoDictionary(word);
        }
        System.out.println("Insertion of Record is done");
        return "HomePage";
	}
	
	@GetMapping("/startsWith/{prefix}")
	public ResponseEntity<List<String>> startsWith(@PathVariable("prefix") String prefix) {
		
		List<String> list1 = trieObj.getAllWordsStartsWith(prefix);
		
		return new ResponseEntity<>(list1,HttpStatus.OK);
	}
	
	@GetMapping("/meaning/{word}")
	public ResponseEntity<dictionary> meaningOfWord(@PathVariable("word") String word ) {
		dictionary meaning = trieObj.getMeaning(word);
		return new ResponseEntity<dictionary>(meaning,HttpStatus.OK);
	}
	
	@GetMapping("")
	public String showHome() {
		return "HomePage";
	}
	
}
