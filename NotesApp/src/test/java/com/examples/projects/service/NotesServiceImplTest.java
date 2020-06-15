package com.examples.projects.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.examples.projects.dao.NotesDao;
import com.examples.projects.dao.NotesDaoImpl;
import com.examples.projects.model.Notes;

import DBTestCases.MasterData;

class NotesServiceImplTest {
	
	@Mock
	private NotesDaoImpl notesDao;
	@InjectMocks 
	private NotesServiceImpl notesServiceImpl;
	
		
	static { 
		File file = new  File("output_service_revised.txt"); 
		if (file.exists()) { 
			try {
			  FileUtils.forceDelete(new File("output_service_revised.txt")); 
			 } catch(IOException e) { 
				
			 } 
		}
	}
		
	@BeforeEach 
	public void init() { 
		MockitoAnnotations.initMocks(this); 
	}

	@Test
	void test() {
	//	fail("Not yet implemented");
	}
	
	@Test
	public void testInsertNote() throws IOException {
		Boolean flag = true;
		Notes note = MasterData.getDetails();
		when(notesServiceImpl.insertNote(note)).thenReturn(flag);
		boolean value = notesServiceImpl.insertNote(note);
		File file = new File("output_service_revised.txt"); 
		FileUtils.write(file,"\n testInsertNote = "+(value?true:false), true);
	}
	
	@Test
	public void testGetNoteById() throws IOException {
		Notes mkNote=new Notes();
		mkNote.setId((long) 10008);
		mkNote.setAuthor("Praveen");
		mkNote.setTitle("DevOps");
		when(notesServiceImpl.getNoteById((long) 10008)).thenReturn(mkNote);
		Notes frmDb = notesServiceImpl.getNoteById((long) 10008);
		System.out.println(mkNote);
		File file = new File("output_service_revised.txt"); 
		FileUtils.write(file,"\n testGetNoteById = "+(frmDb.getAuthor().equals("Praveen")?true:false), true);
		
	}
	
	@Test
	public void testViewlAll() throws Exception {
		
		List<Notes> list = new ArrayList<>();
		List<Notes> noteList;
		list.add(new Notes());
		list.add(new Notes());
	    
	    when(notesServiceImpl.getAllNodes()).thenReturn((List<Notes>) list);
		noteList = notesServiceImpl.getAllNodes();
		File file = new File("output_service_revised.txt");
		FileUtils.write(file, "\n testViewAll = "+(noteList.size()==2?true:false), true); 
	}
	
	@Test
	public void testDeleteNote() throws IOException{
			 Boolean flag = true;
		when(notesServiceImpl.deleteNote((long) 10008)).thenReturn(flag);
		boolean stats = notesServiceImpl.deleteNote((long)10008);
		File file = new File("output_service_revised.txt");
		FileUtils.write(file, "\n testDeleteNote = "+(stats?true:false), true);
		
	}
	
	@Test
	public void testUpdateNote() throws Exception{
		Boolean flag=true;
		Notes note = MasterData.getDetails();
		when(notesServiceImpl.updateNote(note)).thenReturn(note.getId());
		Long testId= notesServiceImpl.updateNote(note);
		File file = new File("output_service_revised.txt");
		FileUtils.write(file, "\n testUpdateNote = "+(testId==note.getId()?true:false), true);
		
	}
}
