package com.student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentOperationsImplement obj = new StudentOperationsImplement();
        Scanner sc = new Scanner(System.in);

        // Update this file path as needed
        String filePath = "C:\\Users\\K Yoganand Varma\\Documents\\StudentData.csv";

        while (true) {
            System.out.println("\n==== STUDENT MANAGEMENT SYSTEM ====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Save to File");
            System.out.println("4. Load from File");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("\n--- Add Student ---");

                     int id;
                    while(true) {
                    	System.out.print("Enter ID: ");
                         id = sc.nextInt();
                    	if(obj.checkId(id))
                    	{
                    		System.out.println("ID ALREADY EXISTS. ENTER A VALID ID: ");
                    	}
                    	else
                    	{
                    		break;
                    	}
                    }
                    
                    sc.nextLine(); // 

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter number of subjects: ");
                    int n = sc.nextInt();
                    double[] marks = new double[n];

                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter mark for subject " + (i + 1) + ": ");
                        marks[i] = sc.nextDouble();
                    }

                    Student student = new Student(id, name, marks);
                    obj.addStudent(student);
                    break;

                case 2:
                    System.out.println("\n--- Displaying All Students ---");
                    obj.displayAllStudents();
                    break;

                case 3:
                    try {
                        obj.saveToFile(filePath);
                        System.out.println("Data saved to file successfully.");
                    } catch (Exception e) {
                        System.out.println("Error saving file: " + e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        obj.loadFromFile(filePath);
                        System.out.println("Data loaded from file successfully.");
                    } catch (Exception e) {
                        System.out.println("Error loading file: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the Student Management System.");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
