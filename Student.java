package com.student;

import java.util.Arrays;

public class Student 
{
	private int id;
	private String name;
	private double marks[];
	
	
	public Student(int id, String name, double[] marks) {
		this.id = id;
		this.name = name;
		this.marks = marks;
	}
	
	
	public String toCSV()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(id).append(",").append(name);
		for(double m:marks)
		{
			sb.append(",").append(m);
		}
		
		return sb.toString();
	}
	
	public static Student FromCSV(String line)
	{
		String data[] = line.split(",");
		int id = Integer.parseInt(data[0]);
		String name = data[1];
		double marks[] = new double[data.length-2];
		for (int i = 2; i < data.length; i++) {
            marks[i - 2] = Double.parseDouble(data[i]);
        }
		return new Student(id, name, marks);
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + Arrays.toString(marks) + "]";
	}
	
	
	
	
}
