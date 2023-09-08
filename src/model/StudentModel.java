package model;

/* @TODO created by Aman Kumar (47) BCA III (2019-22)*/

public class StudentModel {
    int studentId = 0;
    int rollNo = 0;
    String studentName = "";
    String fatherName = "";
    String motherName = "";
    String studentAddress = "";
    String studentMobile = "";
    String studentCourseSession = "";
    String studentClass = "";
    String studentAadharNo = "";

    int studentAddmissionFee = 0;

    String studentAdmissionSlipCode = "";
    Boolean leaveTheStudent = false;

    public StudentModel(int studentId,int rollNo,String studentName, String fatherName, String motherName, String studentAddress, String studentMobile, String studentCourseSession, String studentClass,String studentAadharNo,Integer studentAddmissionFee,String addmissionSlipCode) {
        this.studentId = studentId;
        this.rollNo = rollNo;
        this.studentName = studentName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.studentAddress = studentAddress;
        this.studentMobile = studentMobile;
        this.studentCourseSession = studentCourseSession;
        this.studentClass = studentClass;
        this.studentAadharNo = studentAadharNo;
        this.studentAddmissionFee = studentAddmissionFee;
        this.studentAdmissionSlipCode = addmissionSlipCode;

    }

    //for updating the data
    public StudentModel(int studentId, String studentName, String fatherName, String motherName, String studentAddress, String studentMobile, String studentAadharNo) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.studentAddress = studentAddress;
        this.studentMobile = studentMobile;
        this.studentAadharNo = studentAadharNo;
    }

    public Boolean getLeaveTheStudent() {
        return leaveTheStudent;
    }

    public void setLeaveTheStudent(Boolean leaveTheStudent) {
        this.leaveTheStudent = leaveTheStudent;
    }
    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    public String getStudentAdmissionSlipCode() {
        return studentAdmissionSlipCode;
    }

    public void setStudentAdmissionSlipCode(String studentAdmissionSlipCode) {
        this.studentAdmissionSlipCode = studentAdmissionSlipCode;
    }
    public int getStudentAddmissionFee() {
        return studentAddmissionFee;
    }

    public void setStudentAddmissionFee(int studentAddmissionFee) {
        this.studentAddmissionFee = studentAddmissionFee;
    }
    public String getStudentAadharNo() {
        return studentAadharNo;
    }

    public void setStudentAadharNo(String studentAadharNo) {
        this.studentAadharNo = studentAadharNo;
    }
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(String studentMobile) {
        this.studentMobile = studentMobile;
    }

    public String getStudentCourseSession() {
        return studentCourseSession;
    }

    public void setStudentCourseSession(String studentCourseSession) {
        this.studentCourseSession = studentCourseSession;
    }

    public String getStudentClass() {
        return studentClass.toLowerCase();
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass.toLowerCase();
    }
}
