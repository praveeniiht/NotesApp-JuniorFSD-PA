package com.examples.projects.controller;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.examples.projects.service.NotesService;
import com.examples.projects.service.NotesServiceImpl;


class HomeControllerTest2 {

	
	@Mock
	private NotesService notesService;
	
	@InjectMocks
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
		
	@BeforeEach
	public void setup() {
		System.out.println("Inside the before");
		MockitoAnnotations.initMocks(this);
		this.mockmvc = MockMvcBuilders.standaloneSetup(homeController).build();
		if(mockmvc!=null)
			System.out.println("not null");
		else
			System.out.println("Null");
	}
	
	@Test
	void testShowHomePage() throws Exception {
		System.out.println("Inside the testShowHomePage");
		if(mockmvc!=null)
			System.out.println("not null");
		else
			System.out.println("Null");
		MvcResult result = this.mockmvc.perform(get("/")).andExpect(view().name("index")).andReturn();
	//MvcResult result = mockmvc.perform(get("/")).andExpect(view().name("index")).andReturn();
		File file = new File("output_controller_revised.txt"); 
		FileUtils.write(file, "\n testShowHomePage="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);
	}

	/*
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
	*/
}
