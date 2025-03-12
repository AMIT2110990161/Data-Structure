package LinkedList;

import java.util.Scanner;

class Student {
    long rollNumber;
    String name;
    int age;
    double grade;
    Student next;

    public Student(long rollNumber, String name, int age, double grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentRecordManager {
    private Student head;

    public void addAtBeginning(long rollNumber, String name, int age, double grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addAtEnd(long rollNumber, String name, int age, double grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    public void addAtPosition(int position, long rollNumber, String name, int age, double grade) {
        if (position <= 0) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Student newStudent = new Student(rollNumber, name, age, grade);
        Student temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            addAtEnd(rollNumber, name, age, grade);
        } else {
            newStudent.next = temp.next;
            temp.next = newStudent;
        }
    }

    public void deleteByRollNumber(long rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public Student searchByRollNumber(long rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void updateGrade(long rollNumber, double newGrade) {
        Student student = searchByRollNumber(rollNumber);
        if (student != null) {
            student.grade = newGrade;
        }
    }

    public void displayRecords() {
        Student temp = head;
        while (temp != null) {
            System.out.println("Name: " + temp.name + ", Roll Number: " + temp.rollNumber + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentRecordManager manager = new StudentRecordManager();

        while (true) {
            System.out.println("1. Add Student at Beginning");
            System.out.println("2. Add Student at End");
            System.out.println("3. Add Student at Position");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Search Student by Roll Number");
            System.out.println("6. Update Student Grade");
            System.out.println("7. Display All Students");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 8) break;

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Roll Number: ");
                    long rollNumber = scanner.nextLong();
                    System.out.print("Enter Name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter Grade: ");
                    double grade = scanner.nextDouble();
                    if (choice == 1) manager.addAtBeginning(rollNumber, name, age, grade);
                    else if (choice == 2) manager.addAtEnd(rollNumber, name, age, grade);
                    else {
                        System.out.print("Enter Position: ");
                        int position = scanner.nextInt();
                        manager.addAtPosition(position, rollNumber, name, age, grade);
                    }
                    break;
                case 4:
                    System.out.print("Enter Roll Number to Delete: ");
                    rollNumber = scanner.nextLong();
                    manager.deleteByRollNumber(rollNumber);
                    break;
                case 5:
                    System.out.print("Enter Roll Number to Search: ");
                    rollNumber = scanner.nextLong();
                    Student student = manager.searchByRollNumber(rollNumber);
                    if (student != null) {
                        System.out.println("Name: " + student.name + ", Roll Number: " + student.rollNumber + ", Age: " + student.age + ", Grade: " + student.grade);
                    } else {
                        System.out.println("Student not found");
                    }
                    break;
                case 6:
                    System.out.print("Enter Roll Number to Update Grade: ");
                    rollNumber = scanner.nextLong();
                    System.out.print("Enter New Grade: ");
                    double newGrade = scanner.nextDouble();
                    manager.updateGrade(rollNumber, newGrade);
                    break;
                case 7:
                    manager.displayRecords();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }
}
