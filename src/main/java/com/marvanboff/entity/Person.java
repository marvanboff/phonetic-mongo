package com.marvanboff.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.marvanboff.phonetic.PhoneticEncoder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
@Document(collection = "person")
public class Person {
	
	private String _id;

	private String name;
	
	private List<String> nameEncode;

	public Person(String name) {
		super();
		this.name = name;
		this.nameEncode = PhoneticEncoder.encode(name);
	}
	
}
