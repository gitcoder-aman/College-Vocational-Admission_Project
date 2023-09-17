import model.StudentModel;
import service.StudentService;
import util.CustomException;

import java.util.ArrayList;
import java.util.Scanner;

/* TODO created by Aman Kumar */
public class Main {
    static String studentName = "";
    static String studentFatherName = "";
    static String studentMotherName = "";
    static String studentAddress = "";
    static String studentMobileNo = "";
    static String studentCourseSession = "";
    static String studentAadharNo = "";
    static String studentClass = "";
    static int studentAddmissionFee = 0;

    public static void main(String[] args) throws CustomException {

        StudentService studentService = StudentService.getInstance();

        authenticationFromDepartment(studentService);
    }

    private static void allFeatureAccessHere(Boolean isLoggedIn, StudentService studentService) throws CustomException {
        Scanner scanner = new Scanner(System.in);

        while (isLoggedIn) {
            System.out.println("______________________Vocational Admission Management System__________________");
            System.out.println("1. Addmission Student");
            System.out.println("2. List of All Vocational Student");
            System.out.println("3. List of Student by Course Name");
            System.out.println("4. Update the student Record");
            System.out.println("5. Delete the student Record");
            System.out.println("6. Log Out");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("____________________STUDENT_INSERT_____________________");
                    System.out.println("Name of Student= ");
                    studentName = scanner.nextLine();
                    System.out.println("Name of Student's Father= ");
                    studentFatherName = scanner.nextLine();
                    System.out.println("Name of Student's Mother= ");
                    studentMotherName = scanner.nextLine();
                    System.out.println("Student Address = ");
                    studentAddress = scanner.nextLine();
                    System.out.println("Student Mobile Number = ");
                    studentMobileNo = scanner.nextLine();
                    System.out.println("Student Course Session = ");
                    studentCourseSession = scanner.nextLine();
                    System.out.println("Student Aadhar No = ");
                    studentAadharNo = scanner.nextLine();
                    System.out.println("Student Class = ");
                    studentClass = scanner.nextLine();
                    System.out.println("Student Addmission Fee. = ");
                    studentAddmissionFee = Integer.parseInt(scanner.nextLine());

                    studentService.registerStudent(
                            studentName,
                            studentFatherName,
                            studentMotherName,
                            studentAddress,
                            studentMobileNo,
                            studentCourseSession,
                            studentClass,
                            studentAadharNo,
                            studentAddmissionFee
                    );
                    break;
                case 2:
                    printListOfStudentData(studentService.getListOfVocationStudent());
                    break;
                case 3:
                    System.out.println("Enter the Course Name .Which you want to get list.");
                    String courseName = scanner.nextLine();
                    printListOfStudentData(studentService.getListByCourse(courseName.toLowerCase()));
                    break;
                case 4:
                    System.out.println("____________________STUDENT_INSERT FOR UPDATING_____________________");

                    System.out.println("Enter the id of Student");
                    int studentId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Name of Student= ");
                    studentName = scanner.nextLine();
                    System.out.println("Name of Student's Father= ");
                    studentFatherName = scanner.nextLine();
                    System.out.println("Name of Student's Mother= ");
                    studentMotherName = scanner.nextLine();
                    System.out.println("Student Address = ");
                    studentAddress = scanner.nextLine();
                    System.out.println("Student Mobile Number = ");
                    studentMobileNo = scanner.nextLine();
                    System.out.println("Student Aadhar No = ");
                    studentAadharNo = scanner.nextLine();

                    StudentModel studentModel = new StudentModel(studentId, studentName, studentFatherName, studentMotherName, studentAddress, studentMobileNo, studentAadharNo);
                    studentService.updateStudentRecord(studentModel);
                    break;
                case 5:
                    System.out.println("----------------Leaving the Student from the college------------------");
                    System.out.println("Enter the id of Student");
                    int stId = Integer.parseInt(scanner.nextLine());
                    studentService.deleteStudentModel(stId);
                    break;
                case 6:
                    isLoggedIn = false;
                    System.out.println("Logout Successfully");
                    authenticationFromDepartment(studentService);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void authenticationFromDepartment(StudentService studentService) throws CustomException {
        Boolean isLoginForWhileLoop = true;
        do {
            System.out.println("______________________Vocational Admission Management System__________________");
            System.out.println("1. Signup the Department");
            System.out.println("2. Login the Department");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            String departmentEmail = "";
            String departmentPass = "";

            switch (choice) {
                case 1:
                    System.out.println("____________________DEPARTMENT_SIGNUP_SYSTEM_____________________");
                    System.out.println("------------------Enter the Email:--------------");
                    departmentEmail = scanner.nextLine();
                    System.out.println("------------------Enter the Password-------------");
                    departmentPass = scanner.nextLine();

                    studentService.signupDepartment(departmentEmail.toLowerCase(), departmentPass);
                    break;
                case 2:
                    Boolean isLoggedIn = false;
                    System.out.println("____________________DEPARTMENT_LOGIN_SYSTEM_____________________");
                    System.out.println("------------------Enter the Email:--------------");
                    departmentEmail = scanner.nextLine();
                    System.out.println("------------------Enter the Password-------------");
                    departmentPass = scanner.nextLine();
                    isLoggedIn = studentService.loginDepartment(departmentEmail.toLowerCase(), departmentPass);
                    if (isLoggedIn) {
                        isLoginForWhileLoop = false;
                        allFeatureAccessHere(isLoggedIn,studentService);
                    }
                    break;
                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (isLoginForWhileLoop);
    }

    public static void printStudentData(StudentModel studentModel) {
        if (studentModel != null) {
            System.out.println("____________________STUDENT_DETAILS_____________________");
            System.out.println("Name of Student= " + studentModel.getStudentName());
            System.out.println("Name of Student's Father= " + studentModel.getFatherName());
            System.out.println("Name of Student's Mother= " + studentModel.getMotherName());
            System.out.println("Student Address = " + studentModel.getStudentAddress());
            System.out.println("Student Mobile Number = " + studentModel.getStudentMobile());
            System.out.println("Student Course Session = " + studentModel.getStudentCourseSession());
            System.out.println("Student Aadhar No = " + studentModel.getStudentAadharNo());
            System.out.println("Student Class = " + studentModel.getStudentClass());
            System.out.println("Student Id No. = " + studentModel.getStudentId());
            System.out.println("Student Roll No. = " + studentModel.getRollNo());
            System.out.println("Student Addmission Fee Slip no.. = " + studentModel.getStudentAdmissionSlipCode());
            System.out.println("Student Addmission Fee. = " + studentModel.getStudentAddmissionFee());
            System.out.println("Student Leaving Status. = " + studentModel.getLeaveTheStudent());
        }
    }

    public static void printListOfStudentData(ArrayList<StudentModel> studentModelArrayList) {

        for (int i = 0; i < studentModelArrayList.size(); i++) {
            printStudentData(studentModelArrayList.get(i));
        }
    }
}