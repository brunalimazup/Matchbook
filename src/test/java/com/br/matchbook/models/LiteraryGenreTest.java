package com.br.matchbook.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
public class LiteraryGenreTest {
	private LiteraryGenre literaryGenre;
	@Before
	public void preparar () {
		literaryGenre = new LiteraryGenre();
		

		literaryGenre.setId(null);
		literaryGenre.setName("Terror");
	
	}
	@Test
	public void getName () {
		assertEquals(literaryGenre.getName(), "Terror");
	}
	@Test
	public void setName () {
		assertEquals("Robô", literaryGenre.getName());
	}
}

