package com.marvanboff.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.language.Metaphone;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import com.marvanboff.PhoneticMongoApplication;
import com.marvanboff.entity.Person;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = PhoneticMongoApplication.class)
@DataMongoTest
public class PhoneticMongoService {
	
	@Autowired
    private MongoTemplate mongoTemplate;
	
	private static boolean executedOnce;
	
	@Before
	public void createDataBase() {
		
		if(executedOnce) {
			return;
		}
		
		createNames().forEach(person -> mongoTemplate.save(person));
	}
	
	private List<Person> createNames() {
		
		executedOnce = true;
		List<Person> list = new ArrayList<>();
		
		list.add(new Person("Franciele da Silva"));
		list.add(new Person("Francisco Teixeira"));
		list.add(new Person("Fabrice da Silveira"));
		list.add(new Person("Joaquim Correa"));
		list.add(new Person("Thiago Pereira"));
		list.add(new Person("Tiago Jorge"));
		list.add(new Person("Fernando da Silva"));
		list.add(new Person("Michelle das Missões"));
		list.add(new Person("Michele Carvalho"));
		list.add(new Person("Janaína das Missões"));
		list.add(new Person("Janaina da Silva"));
		list.add(new Person("Matheus Pereira"));
		list.add(new Person("Mateus Santos"));

		return list;
	}
	
	@Test
	public void deveRetornarFrancielePesquisandoPorFran() {
		
		String franEncode = new Metaphone().encode("Fran");
		
		Query query = new Query();
		query.addCriteria(Criteria.where("nomeEncode").regex(franEncode + "*"));
		 
		List<Person> find = mongoTemplate.find(query, Person.class);
		
		Assert.assertEquals(find.get(0).getName(), "Franciele da Silva");
		Assert.assertEquals(find.get(1).getName(), "Francisco Teixeira");
		
	}
	
	/*@Test
	public void deveRetornarFrancielePesquisandoPorThiago() {
		
		String tiago = new Metaphone().encode("Matheus");
		
		Query query = new Query();
		query.addCriteria(Criteria.where("nomeEncode").regex(tiago + ".*"));
		 
		List<ListaEntity> find = mongoTemplate.find(query, ListaEntity.class);
		
		System.out.println(find);
		
	}*/
	
	
}

