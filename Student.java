package student;

import java.util.Scanner;

public class Student {

    private String name;
    private int rollNo;
    private double[] marks;
    private double average;

    // Constructor
    public Student(String name, int rollNo, double[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    // Calculate average
    public void calculateAverage() {
        double total = 0;
        for (double m : marks) {
            total += m;
        }
        this.average = total / marks.length;
    }

    // Determine grade
    public char getGrade() {
        if (average >= 80) return 'A';
        else if (average >= 60) return 'B';
        else return 'C';
    }

    // Display student info
    public void displayInfo() {
        System.out.println("\n--- Student Result ---");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Average Marks: " + average + "%");
        System.out.println("Grade: " + getGrade());
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Ask number of students
        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 1; i <= numStudents; i++) {

            System.out.println("\nEnter details for Student " + i);

            System.out.print("Enter Student Name: ");
            String n = sc.nextLine();

            System.out.print("Enter Roll Number: ");
            int r = sc.nextInt();

            double[] m = new double[5];
            System.out.println("Enter marks for 5 subjects:");
            for (int j = 0; j < 5; j++) {
                System.out.print("Subject " + (j + 1) + ": ");
                m[j] = sc.nextDouble();
            }
            sc.nextLine(); // consume newline

            // Create object
            Student s = new Student(n, r, m);
            s.calculateAverage();
            s.displayInfo();
        }

        sc.close();
    }
}


