package com.examples.projects.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.examples.projects.service.NotesService;

public class TestController 
{
	@Mock
	private NotesService notesService;

	
	@InjectMocks
	private HomeController hController;

	private MockMvc mockMvc;

	// -------------------------------------------------------------------------------------------------------------------
	static {
		File file = new File("controller_output_revised.txt");
		if (file.exists()) {
			try {
				FileUtils.forceDelete(new File("controller_output_revised.txt"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}
	}

	// -------------------------------------------------------------------------------------------------------------------
	@Before
	public void setup() throws Exception 
	{
		System.out.println("Inside the before..");
		MockitoAnnotations.initMocks(this);
		System.out.println("after the init..");
		mockMvc = MockMvcBuilders.standaloneSetup(hController).build();
		System.out.println("last line of  the before..");
	}

	// -------------------------------------------------------------------------------------------------------------------
	@Test
	public void testLoadingPageUrl() throws Exception 
	{
		System.out.println("First line of loading page");
		MvcResult result = this.mockMvc.perform(get("/")).andExpect(view().name("index")).andReturn();

		File file = new File("controller_output_revised.txt");
		FileUtils.write(file,
				"\ntestLoadingPageUrl=" + (result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);
	}

	/* -------------------------------------------------------------------------------------------------------------------
	@Test 
	public void testAddPost() throws Exception 
	{ 
		MvcResult result = this.mockMvc.perform(get("/addNewPost")).andExpect(status().isOk()).andExpect(view().name("addPost")).andReturn();
	    
		File file = new File("controller_output_revised.txt"); 
		FileUtils.write(file, "\ntestAddPost="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true); 
	}

	@Test 
	public void testSavePosts() throws Exception 
	{ 
		Gson gson = new	Gson();
		when(postService.savePost(MasterData.getPostDetails())).thenReturn(false);
	  
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/savePost")
										.content(gson.toJson(MasterData.getPostDetails()))
										.contentType(MediaType.APPLICATION_JSON)
										.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();	
		
		File file = new File("controller_output_revised.txt"); 
		FileUtils.write(file, "\ntestSavePosts="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true); 		
	}

	@Test 
	public void testSavePostsCase() throws Exception
	{ 
		Gson gson = new	Gson();
		when(postService.savePost(MasterData.getPostDetails())).thenReturn(true);
			
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/savePost")
										.content(gson.toJson(MasterData.getPostDetails()))
										.contentType(MediaType.APPLICATION_JSON)
										.accept(MediaType.APPLICATION_JSON);

		MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
		
		File file = new File("controller_output_revised.txt"); 
		FileUtils.write(file, "\ntestSavePostsCase="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);		
	}

	@Test 
	public void testViewAllPosts() throws Exception 
	{ 
		List<Posts> posts =	new ArrayList<Posts>(); 
		posts.add(new Posts());
		posts.add(new Posts());
		
		when(postService.getAllPosts()).thenReturn((List<Posts>) posts);
		
		MvcResult result = this.mockMvc.perform(get("/viewAllPosts")).andExpect(status().isOk()).andExpect(view().name("viewPosts")).andReturn();

		File file = new File("controller_output_revised.txt"); 
		FileUtils.write(file, "\ntestViewAllPosts="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);
	}

	@Test 
	public void testViewAllPostsCase() throws Exception 
	{
		when(postService.getAllPosts()).thenReturn(null);
		
		MvcResult result = this.mockMvc.perform(get("/viewAllPosts")).andExpect(status().isOk()).andExpect(view().name("visitor")).andReturn(); 
		
		File file = new File("controller_output_revised.txt"); 
		FileUtils.write(file, "\ntestViewAllPostsCase="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);
	}
	  
	//-------------------------------------------------------------------------------------------------------------------
	@Test 
	public void testAddComments() throws Exception 
	{
		MvcResult result = this.mockMvc.perform(get("/addComments")).andExpect(status().isOk()).andExpect(view().name("addComment")).andReturn();
		
		File file = new File("controller_output_revised.txt"); 
		FileUtils.write(file, "\ntestAddComments="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true); 
	}
	  
	@Test 
	public void testSaveComments() throws Exception 
	{ 
		Gson gson = new  Gson();
		when(commentService.saveComment(MasterData.getCommentDetails())).thenReturn(false);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/saveComment")
										.content(gson.toJson(MasterData.getCommentDetails()))
										.contentType(MediaType.APPLICATION_JSON)
										.accept(MediaType.APPLICATION_JSON);

		MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
		
		File file = new File("controller_output_revised.txt"); 
		FileUtils.write(file, "\ntestSaveComments="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);
	}

	@Test 
	public void testSaveCommentsCase() throws Exception 
	{ 
		Gson gson = new Gson();
		when(commentService.saveComment(MasterData.getCommentDetails())).thenReturn(true);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/saveComment")
										.content(gson.toJson(MasterData.getCommentDetails()))
										.contentType(MediaType.APPLICATION_JSON)
										.accept(MediaType.APPLICATION_JSON);

		MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
		
		File file = new File("controller_output_revised.txt"); 
		FileUtils.write(file, "\ntestSaveCommentsCase="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);	
	}
	  
	//--------------------------------------------------------------------------------------------------------------------
	@Test 
	public void testViewAllDiscussions() throws Exception 
	{
		List<Posts> discuss = new ArrayList<Posts>();
		discuss.add(new Posts());
		discuss.add(new Posts());
		
		when(postService.getAllPosts()).thenReturn((List<Posts>) discuss);
		
		MvcResult result = this.mockMvc.perform(get("/viewDiscussion")).andExpect(status().isOk()).andExpect(view().name("viewDiscussionList")).andReturn();

		File file = new File("controller_output_revised.txt"); 
		FileUtils.write(file, "\ntestViewAllDiscussions="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);
	}
	  
	@Test 
	public void testViewAllDiscussionsCase() throws Exception 
	{
		when(postService.getAllPosts()).thenReturn(null);
		
		MvcResult result = this.mockMvc.perform(get("/viewDiscussion")).andExpect(status().isOk()).andExpect(view().name("visitor")).andReturn(); 
		
		File file = new File("controller_output_revised.txt"); 
		FileUtils.write(file, "\ntestViewAllDiscussionsCase="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);		
	}	 */
}