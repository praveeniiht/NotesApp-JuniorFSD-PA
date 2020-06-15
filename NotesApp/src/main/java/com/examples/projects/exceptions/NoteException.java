package com.examples.projects.exceptions;

public class NoteException extends RuntimeException{

	public NoteException() {
		super("Notes Insertion or Updataion not possible");
	}
}
