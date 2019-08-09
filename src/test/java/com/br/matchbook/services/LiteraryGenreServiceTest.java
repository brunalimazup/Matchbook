package com.br.matchbook.services;


import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.matchbook.models.LiteraryGenre;

@RunWith(SpringRunner.class)
public class LiteraryGenreServiceTest {
	
	private LiteraryGenre literaryGenre;
	
	@Before
	public void prepare() {
		
		literaryGenre = new LiteraryGenre();
		
		literaryGenre.setId(null);
		literaryGenre.setName("Ação e Aventura");
		
			
	}
	
	@Test
	public void getName() {
		assertEquals(literaryGenre.getName(), "Ação e Aventura");
	}
	
	//@Test
	//public void setName() {
	//	assertEquals("As crônicas de naŕnia", literaryGenre.getName());
	//}
}
