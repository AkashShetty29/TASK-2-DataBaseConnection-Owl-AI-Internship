package main;

import java.util.List;
import java.util.Scanner;

import doa.StudentDao;
import entity.Student;

public class Main {

    private static StudentDao studentDao = new StudentDao();
    private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        System.out.println("Student Database Retrieval System");
        System.out.println("====================================\n");
        
        // Test database connection first
        if (!studentDao.testConnection()) {
            System.out.println("Cannot proceed without database connection. Exiting...");
            return;
        }
        
        showMenu();
        scanner.close();
    }
    
    private static void showMenu() {
        while (true) {
            System.out.println("\n RETRIEVAL MENU");
            System.out.println("1. View All Students");
            System.out.println("2. Find Student by ID");
            System.out.println("3. Find Students by Course");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            
            int choice = getIntInput();
            
            switch (choice) {
                case 1 -> displayAllStudents();
                case 2 -> findStudentById();
                case 3 -> findStudentsByCourse();
                case 4 -> {
                    System.out.println("Thank you for using Student Database System!");
                    return;
                }
                default -> System.out.println("Invalid option! Please try again.");
            }
        }
    }
    
    private static void displayAllStudents() {
        System.out.println("\n ALL STUDENTS");
        List<Student> students = studentDao.getAllStudents();
        
        if (students.isEmpty()) {
            System.out.println("No students found in database.");
        } else {
            printTableHeader();
            for (Student student : students) {
                System.out.println(student.toTableRow());
            }
            printTableFooter();
        }
    }
    
    private static void findStudentById() {
        System.out.println("\n FIND STUDENT BY ID");
        System.out.print("Enter student ID: ");
        int id = getIntInput();
        
        Student student = studentDao.getStudentById(id);
        if (student != null) {
            printTableHeader();
            System.out.println(student.toTableRow());
            printTableFooter();
        }
    }
    
    private static void findStudentsByCourse() {
        System.out.println("\n FIND STUDENTS BY COURSE");
        System.out.print("Enter course name: ");
        String course = scanner.nextLine();
        
        List<Student> students = studentDao.getStudentsByCourse(course);
        
        if (students.isEmpty()) {
            System.out.println("No students found in course: " + course);
        } else {
            System.out.println("\nStudents in " + course + ":");
            printTableHeader();
            for (Student student : students) {
                System.out.println(student.toTableRow());
            }
            printTableFooter();
        }
    }
    
    private static void printTableHeader() {
        System.out.println("+-----+----------------------+---------------------------+-----+----------------------+");
        System.out.println("| ID  | Name                 | Email                     | Age | Course               |");
        System.out.println("+-----+----------------------+---------------------------+-----+----------------------+");
    }
    
    private static void printTableFooter() {
        System.out.println("+-----+----------------------+---------------------------+-----+----------------------+");
    }
    
    private static int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
            return -1;
        }
		

	}

}
