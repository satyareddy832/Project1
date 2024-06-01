package com.satya.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satya.model.dictionary;

public interface IDictionaryRepo extends JpaRepository<dictionary, String> {
}
