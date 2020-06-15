package com.examples.projects.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.examples.projects.service.NotesService;
import com.examples.projects.service.NotesServiceImpl;


@RunWith(MockitoJUnitRunner.class)
class HomeControllerTest2 {

	
	@Autowired
	private WebApplicationContext context;
	
	@Mock
	private HomeController homeController;
	private MockMvc mockmvc;
	
	static {
		File file = new File("output_controller_revised.txt");
		if (file.exists()) {
			try {
				FileUtils.forceDelete(new File("output_controller_revised.txt"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}
	}
	
	
	//@InjectMocks
	//private NotesServiceImpl notesService;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockmvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	void testShowHomePage() throws Exception {
		//fail("Not yet implemented");
	//	this.mockmvc.perform(get("/")).andExpect(status().isOk())
	//	.andExpect(view().name("index"));
		
		this.mockmvc.perform(get("/")
                .accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
	}

	@Test
	void testAddNote() throws Exception {
	//	fail("Not yet implemented");
		this.mockmvc.perform(get("/addNote")).andExpect(status().isOk())
		.andExpect(view().name("addnote"));
	}

	@Test
	void testDeleteNote() throws Exception {
		//fail("Not yet implemented");
		this.mockmvc.perform(get("/deleteNote")).andExpect(status().isOk())
		.andExpect(view().name("statusmanager"));
	}

	@Test
	void testEditNote() throws Exception {
		//fail("Not yet implemented");
		this.mockmvc.perform(get("/editNote")).andExpect(status().isOk())
		.andExpect(view().name("update"));
	}

	@Test
	void testViewlAll() throws Exception {
		//fail("Not yet implemented");
		this.mockmvc.perform(get("/statusManager")).andExpect(status().isOk())
		.andExpect(view().name("statusmanager"));
	}

	@Test
	void testUpdateNote() throws Exception {
		//fail("Not yet implemented");
		this.mockmvc.perform(get("/viewlAll")).andExpect(status().isOk())
		.andExpect(view().name("viewall"));
	}

}
