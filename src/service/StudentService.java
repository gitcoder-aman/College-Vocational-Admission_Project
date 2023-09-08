package service;

import data.StudentDao;
import model.StudentModel;
import util.CustomException;

import java.util.ArrayList;

/* TODO created by Aman Kumar (47) BCA III (2019-22)*/
public class StudentService {
    public static StudentService instance = null;

    private StudentService() {

    }

    //here i'm use singleton one of the most important concept of LLD
    public static StudentService getInstance() {
        if (instance == null) {
            instance = new StudentService();
        }
        return instance;
    }

    StudentDao studentDao = StudentDao.getInstance();

    public StudentModel registerStudent(String studentName, String fatherName, String motherName,
                                        String studentAddress, String studentMobile,
                                        String studentCourseSession, String studentClass, String studentAadharNo, Integer addmissionFee) throws CustomException {
        //here the check data of all the required.
        if (studentName.isEmpty()) {
            throw new CustomException("Student Name is Empty!!");
        } else if (fatherName.isEmpty()) {
            throw new CustomException("Father Name is Empty!!");
        } else if (motherName.isEmpty()) {
            throw new CustomException("Mother Name is Empty!!");
        } else if (studentAddress.isEmpty()) {
            throw new CustomException("Student Address is Empty!!");
        } else if (studentCourseSession.isEmpty()) {
            throw new CustomException("Student Course Session is Empty");
        } else if (studentMobile.isEmpty()) {
            throw new CustomException("Student Mobile is Empty!!");
        } else if (studentClass.isEmpty()) {
            throw new CustomException("Student Class is Empty!!");
        } else if (studentAadharNo.isEmpty()) {
            throw new CustomException("Student Aadhar is Empty!!");
        } else if (addmissionFee == 0) {
            throw new CustomException("Student Addmission Fee is Empty!!");
        }
        return studentDao.registerStudent(studentName, fatherName, motherName, studentAddress, studentMobile, studentCourseSession, studentClass, studentAadharNo, addmissionFee);
    }

    public ArrayList getListOfVocationStudent() throws CustomException {
        return studentDao.getAllVocationStudent();
    }

    public ArrayList getListByCourse(String courseName) throws CustomException {
        return studentDao.getListByCourse(courseName);
    }

    public StudentModel updateStudentRecord(StudentModel studentModel) throws CustomException {
        if (studentModel.getStudentId() == 0) {
            throw new CustomException("Student Id No is Empty");
        }
        try {
            return studentDao.updateStudentRecord(studentModel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteStudentModel(Integer studentId) throws CustomException {
        if(studentId == 0){
            throw new CustomException("Student Id no is not Exist.");
        }

        try {
            studentDao.deleteStudentRecord(studentId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
