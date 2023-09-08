package data;

import model.ClassModel;
import model.StudentModel;
import util.CustomException;
import util.IdGenerator;

import java.util.ArrayList;
import java.util.HashMap;

/*TODO created by Aman Kumar (47) BCA III (2019-22)*/
public class StudentDao {

    public static StudentDao instance = null;

    private StudentDao() {

    }

    public static StudentDao getInstance() {
        if (instance == null) {
            instance = new StudentDao();
        }
        return instance;
    }

    private HashMap<Integer, StudentModel> studentHashMap = new HashMap<>();  // map with studentId and student model
    private ArrayList<StudentModel> studentList = new ArrayList();  //here all the student list
    private ArrayList<ClassModel> classByRollNoList = new ArrayList();
    private ArrayList<Integer> studentIdList = new ArrayList<>();
    private ArrayList<String> studentAadharCardForUniqueData = new ArrayList<>();
    private boolean isClassExist = false;
    private ClassModel classModel = new ClassModel();


    public StudentModel registerStudent(String studentName, String fatherName, String motherName,
                                        String studentAddress, String studentMobile,
                                        String studentCourseSession, String studentClass, String studentAadharNo, Integer addmissionFee) throws CustomException {

        int studentId = IdGenerator.getStudentId();
        int rollNo = 0;

        if (studentAadharCardForUniqueData.contains(studentAadharNo)) {
            throw new CustomException("This Student is already exist as per Aadhar!.");
        }

        for (int k = 0; k < classByRollNoList.size(); k++) {  //checking the class is existed or not in classByRollNoList
            if (classByRollNoList.get(k).getClassName().equals(studentClass)) {
                classModel = classByRollNoList.get(k);
                isClassExist = true;
            }
        }
        if (isClassExist) {
            classModel.getStudentIdList().add(studentId);
            rollNo = classModel.getStudentIdList().size();
            isClassExist = false;
        } else {
            //new model class create when no exist class
            classModel = new ClassModel();
            studentIdList = new ArrayList<>();
            studentIdList.add(studentId);
            classModel.setClassName(studentClass);
            classModel.setStudentIdList(studentIdList);
            rollNo = classModel.getStudentIdList().size();
            classByRollNoList.add(classModel);
        }

        StudentModel studentModel = new StudentModel(studentId, rollNo, studentName,
                fatherName, motherName, studentAddress, studentMobile, studentCourseSession, studentClass, studentAadharNo, addmissionFee, "S00" + IdGenerator.getSlipCode());

        //if a new student getting addmission in vocation course
        studentHashMap.put(studentId, studentModel);
        studentAadharCardForUniqueData.add(studentModel.getStudentAadharNo());
        studentList.add(studentModel);

        System.out.println("__________Successfully done of addmission process_______");

        return studentModel;
    }

    public ArrayList getAllVocationStudent() throws CustomException {
        if (studentList.isEmpty()) {
            throw new CustomException("No Record Found!");
        }
        return studentList;
    }

    public ArrayList getListByCourse(String className) throws CustomException {

        if (classByRollNoList.isEmpty()) {
            throw new CustomException("No Record Found");
        }
        ArrayList<ClassModel> classModelArrayList = new ArrayList();
        for (int i = 0; i < classByRollNoList.size(); i++) {   //model position get according to className
            if (classByRollNoList.get(i).getClassName().equals(className)) {
                classModelArrayList.add(classByRollNoList.get(i));
            }
        }
        ArrayList<StudentModel> getListByCourse = new ArrayList<>();
        for (int i = 0; i < classModelArrayList.get(0).getStudentIdList().size(); i++) {
            int studentIdInsideInCourse = classModelArrayList.get(0).getStudentIdList().get(i);
            StudentModel studentModel = studentHashMap.get(studentIdInsideInCourse);
            getListByCourse.add(studentModel);
        }
        return getListByCourse;
    }

    public StudentModel updateStudentRecord(StudentModel studentModel) throws Exception {

        if (!studentHashMap.containsKey(studentModel.getStudentId())) {
            throw new CustomException("No Student Record Found!!");
        }


        for (int i = 0; i < studentList.size(); i++) {
            if (studentModel.getStudentId() == studentList.get(i).getStudentId()) {


                studentList.get(i).setStudentName(studentModel.getStudentName());

                studentList.get(i).setFatherName(studentModel.getFatherName());

                studentList.get(i).setMotherName(studentModel.getMotherName());

                studentList.get(i).setStudentAddress(studentModel.getStudentAddress());

                studentList.get(i).setStudentMobile(studentModel.getStudentMobile());

                studentList.get(i).setStudentAadharNo(studentModel.getStudentAadharNo());
                break;
            }
        }

        return studentModel;
    }

    public void deleteStudentRecord(Integer studentId) throws Exception {
        if (!studentHashMap.containsKey(studentId)) {
            throw new CustomException("No Student Record Found!!");
        }

        for (int i = 0; i < studentList.size(); i++) {
            if (studentId == studentList.get(i).getStudentId()) {
                studentList.get(i).setLeaveTheStudent(true);
                break;
            }
        }
    }

}
