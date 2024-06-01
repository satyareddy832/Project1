package com.satya.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class dictionary {
	@Id
	private String word;
	private String meaning;
	private String pos;
	private String example;
}
