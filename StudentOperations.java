package com.student;

import java.io.IOException;

public interface StudentOperations 
{
	void addStudent(Student std);
	void displayAllStudents();
	void saveToFile(String fileName) throws IOException;
	void loadFromFile(String fileName) throws IOException;
	
}
