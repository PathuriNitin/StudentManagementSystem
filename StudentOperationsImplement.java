package com.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentOperationsImplement implements StudentOperations
{

	private List<Student> studentData = new ArrayList<>();
	
	
	public boolean checkId(int id)
	{
		for(Student std:studentData)
		{
			if(std.getId()==id)
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void addStudent(Student std) 
	{
			studentData.add(std);		
	}

	@Override
	public void displayAllStudents() {
		
		System.out.println("Student Data:\n");
		for(Student std:studentData)
		{
			System.out.println(std);
		}
		
	}

	@Override
	public void saveToFile(String fileName) throws IOException
	{
		FileWriter file = new FileWriter(fileName); 
		BufferedWriter writeData = new BufferedWriter(file);
		for(Student std:studentData)
		{
			writeData.write(std.toCSV());
			writeData.newLine();
		}
		writeData.close();
	}

	@Override
	public void loadFromFile(String filePath) throws IOException 
	{
		studentData.clear();
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            studentData.add(Student.FromCSV(line));
        }
        reader.close();
		
	}


}
