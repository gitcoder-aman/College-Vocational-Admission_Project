import model.StudentModel;
import service.StudentService;
import util.CustomException;
import java.util.ArrayList;
import java.util.Scanner;

/* TODO created by Aman Kumar */
public class Main {
    public static void main(String[] args) throws CustomException, InterruptedException {

        System.out.println("____________Launching the Vocational Management System....______________");
        Thread.sleep(2000);

        StudentService studentService = StudentService.getInstance();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("______________________Vocational Admission Management System__________________");
            System.out.println("1. Addmission Student");
            System.out.println("2. List of All Vocational Student");
            System.out.println("3. List of Student of Course Name");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("____________________STUDENT_INSERT_____________________");
                    System.out.println("Name of Student= ");
                    String studentName = scanner.nextLine();
                    System.out.println("Name of Student's Father= ");
                    String studentFatherName = scanner.nextLine();
                    System.out.println("Name of Student's Mother= ");
                    String studentMotherName = scanner.nextLine();
                    System.out.println("Student Address = ");
                    String studentAddress = scanner.nextLine();
                    System.out.println("Student Mobile Number = ");
                    String studentMobileNo = scanner.nextLine();
                    System.out.println("Student Course Session = ");
                    String studentCourseSession = scanner.nextLine();
                    System.out.println("Student Aadhar No = ");
                    String studentAadharNo = scanner.nextLine();
                    System.out.println("Student Class = ");
                    String studentClass = scanner.nextLine();
                    System.out.println("Student Addmission Fee. = ");
                    int studentAddmissionFee = Integer.parseInt(scanner.nextLine());
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
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void printStudentData(StudentModel studentModel){
        if(studentModel != null){
            System.out.println("____________________STUDENT_DETAILS_____________________");
            System.out.println("Name of Student= "+studentModel.getStudentName());
            System.out.println("Name of Student's Father= "+studentModel.getFatherName());
            System.out.println("Name of Student's Mother= "+studentModel.getMotherName());
            System.out.println("Student Address = "+studentModel.getStudentAddress());
            System.out.println("Student Mobile Number = "+studentModel.getStudentMobile());
            System.out.println("Student Course Session = "+studentModel.getStudentCourseSession());
            System.out.println("Student Aadhar No = "+studentModel.getStudentAadharNo());
            System.out.println("Student Class = "+studentModel.getStudentClass());
            System.out.println("Student Roll No. = "+studentModel.getStudentId());
            System.out.println("Student Addmission Fee Slip no.. = "+studentModel.getStudentAdmissionSlipCode());
            System.out.println("Student Addmission Fee. = "+studentModel.getStudentAddmissionFee());
        }
    }
    public static void printListOfStudentData(ArrayList<StudentModel> studentModelArrayList){

        for (int i = 0; i < studentModelArrayList.size() ; i++){
            printStudentData(studentModelArrayList.get(i));
        }
    }
}