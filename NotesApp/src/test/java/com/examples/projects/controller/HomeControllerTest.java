package com.examples.projects.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.examples.projects.service.NotesService;
import com.examples.projects.service.NotesServiceImpl;


class HomeControllerTest {

	
	//NotesService notesService = new NotesServiceImpl();
	
	@Autowired
	private MockMvc mockmvc;
	
//	@InjectMocks
//	private HomeController homeController;
	
	
	@Test
	public void shouldReturnDefaultMessage() throws Exception {
				
	}
	
	@Test
	void testShowHomePage() {
		
		fail("Not yet implemented");
	}

	@Test
	void testAddNote() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteNote() {
		fail("Not yet implemented");
	}

	@Test
	void testEditNote() {
		fail("Not yet implemented");
	}

	@Test
	void testStatusManager() {
		fail("Not yet implemented");
	}

	@Test
	void testViewlAll() {
		fail("Not yet implemented");
	}

}
