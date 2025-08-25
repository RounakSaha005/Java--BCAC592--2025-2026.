import java.util.Scanner;
class Student {
    private String name;
    private int rollNumber;
    private String className;
    Student(String name, int rollNumber, String className) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.className = className;
    }
    public String getName() {
        return this.name;
    }
    public int getRollNumber() {
        return this.rollNumber;
    }
    public String getClassName() {
        return this.className;
    }
}
class Subject {
    private String subject;
    private int marks;
    Subject(String subject, int marks) {
        this.subject = subject;
        this.marks = marks;
    }
    public String getSubject() {
        return subject;
    }
    public int getMarks() {
        return marks;
    }
}
class ReportCard {
    private Student student;
    private Subject[] subjects;
    ReportCard(Student student, Subject[] subjects) {
        this.student = student;
        this.subjects = subjects;
    }
    public void displayReportCard() {
        int totalMarks = 0;
        System.out.println("\nREPORT CARD: -");
        System.out.printf("%-12s : %d%n", "Roll No", student.getRollNumber());
        System.out.printf("%-12s : %s%n", "Name", student.getName());
        System.out.printf("%-12s : %s%n", "Class", student.getClassName());
        System.out.println("\nSubjects:");
        for (Subject sub : subjects) {
            System.out.printf("%-12s : %d%n", sub.getSubject(), sub.getMarks());
            totalMarks += sub.getMarks();
        }
        double percentage = (double) totalMarks / subjects.length;
        String grade = calculateGrade(percentage);
        System.out.printf("%n%-12s : %d%n", "Total Marks", totalMarks);
        System.out.printf("%-12s : %.2f%%%n", "Percentage", percentage);
        System.out.printf("%-12s : %s%n", "Grade", grade);
        System.out.println("===============================\n");

    }
    private String calculateGrade(double percentage) {
        if (percentage >= 90) return "O";
        else if (percentage >= 80) return "E";
        else if (percentage >= 70) return "A";
        else if (percentage >= 60) return "B";
        else if (percentage >= 50) return "C";
        else if (percentage >= 40) return "D";
        else if (percentage <= 39) return "RE-TEST";
        else return "Fail";
    }
}
class ReportCardSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= numStudents; i++) {
            System.out.println("\nEnter details for Student: - ");
            System.out.print("Enter Roll No: ");
            int rollNo = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Class: ");
            String className = sc.nextLine();
            Student student = new Student(name, rollNo, className);
            System.out.print("Enter number of subjects: ");
            int numSubjects = sc.nextInt();
            sc.nextLine();
            Subject[] subjects = new Subject[numSubjects];
            for (int j = 0; j < numSubjects; j++) {
                System.out.print("Enter Subject " + (j + 1) + " name: ");
                String subName = sc.nextLine();
                System.out.print("Enter marks for " + subName + ": ");
                int marks = sc.nextInt();
                sc.nextLine();
                subjects[j] = new Subject(subName, marks);
            }
            ReportCard rc = new ReportCard(student, subjects);
            rc.displayReportCard();
        }
        sc.close();
    }
}
/*Output: - 
Enter number of students: 2

Enter details for Student: - 
Enter Roll No: 78
Enter Name: Rounak Saha
Enter Class: BCA
Enter number of subjects: 4
Enter Subject 1 name: PHP with My SQL
Enter marks for PHP with My SQL: 85
Enter Subject 2 name: Object Oriented Programming with Java
Enter marks for Object Oriented Programming with Java: 75
Enter Subject 3 name: Financial Management
Enter marks for Financial Management: 70
Enter Subject 4 name: Entrepreneurship
Enter marks for Entrepreneurship: 80

REPORT CARD: -
Roll No      : 78
Name         : Rounak Saha
Class        : BCA

Subjects:
PHP with My SQL : 85
Object Oriented Programming with Java : 75
Financial Management : 70
Entrepreneurship : 80

Total Marks  : 310
Percentage   : 77.50%
Grade        : A
===============================


Enter details for Student: -
Enter Roll No: 88
Enter Name: Samriddha Dey
Enter Class: BCA
Enter number of subjects: 4
Enter Subject 1 name: PHP with My SQL
Enter marks for PHP with My SQL: 75
Enter Subject 2 name: Object Oriented Programming with Java
Enter marks for Object Oriented Programming with Java: 65
Enter Subject 3 name: Financial Management
Enter marks for Financial Management: 60
Enter Subject 4 name: Entrepreneurship
Enter marks for Entrepreneurship: 70

REPORT CARD: -
Roll No      : 88
Name         : Samriddha Dey
Class        : BCA

Subjects:
PHP with My SQL : 75
Object Oriented Programming with Java : 65
Financial Management : 60
Entrepreneurship : 70

Total Marks  : 270
Percentage   : 67.50%
Grade        : B
===============================
 */