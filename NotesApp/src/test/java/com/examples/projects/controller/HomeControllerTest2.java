package com.examples.projects.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.examples.projects.service.NotesService;
import com.examples.projects.service.NotesServiceImpl;


@RunWith(MockitoJUnitRunner.class)
class HomeControllerTest2 {

	
	@Autowired
	private WebApplicationContext context;
	@Mock
	private NotesService notesService;
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
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockmvc = MockMvcBuilders.standaloneSetup(homeController).build();
	}
	
	@Test
	void testShowHomePage() throws Exception {
		MvcResult result = this.mockmvc.perform(get("/")).andExpect(view().name("index")).andReturn();
		File file = new File("output_controller_revised.txt"); 
		//FileUtils.write(file, "\n testShowHomePage="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);
		FileUtils.write(file, "\n testShowHomePage="+(result!=null ? true : false), true);
	}

	@Test
	void testStatusPage() throws Exception {
		MvcResult result = this.mockmvc.perform(get("/statusManager")).andExpect(view().name("statusmanager")).andReturn();
		File file = new File("output_controller_revised.txt"); 
		//FileUtils.write(file, "\n testShowHomePage="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);
		FileUtils.write(file, "\n testStatusPage="+(result!=null ? true : false), true);
	}
	
	@Test
	void testViewAllPage() throws Exception {
		MvcResult result = this.mockmvc.perform(get("/viewlAll")).andExpect(view().name("viewall")).andReturn();
		File file = new File("output_controller_revised.txt"); 
		//FileUtils.write(file, "\n testShowHomePage="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);
		FileUtils.write(file, "\n testViewAllPage="+(result!=null ? true : false), true);
	}
	
	@Test
	void testUpdatePage() throws Exception {
		MvcResult result = this.mockmvc.perform(get("/updateNote")).andExpect(view().name("index")).andReturn();
		File file = new File("output_controller_revised.txt"); 
		//FileUtils.write(file, "\n testShowHomePage="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);
		FileUtils.write(file, "\n testViewAllPage="+(result!=null ? true : false), true);
	}
	
}
