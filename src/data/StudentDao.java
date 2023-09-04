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

    private HashMap<Integer, StudentModel> studentHashMap = new HashMap<>();  // map with aadharNo and student model
    private ArrayList<StudentModel> studentList = new ArrayList();  //here all the student list
    private ArrayList<ClassModel> classByRollNoList = new ArrayList();
    private ArrayList<Integer> rollNoList;
    private boolean isClassExist = false;
    private ClassModel classModel = null;


    public StudentModel registerStudent(String studentName, String fatherName, String motherName,
                                        String studentAddress, String studentMobile,
                                        String studentCourseSession, String studentClass, String studentAadharNo, Integer addmissionFee) throws CustomException {

        StudentModel studentModel = new StudentModel(IdGenerator.getRollNo(), studentName,
                fatherName, motherName, studentAddress, studentMobile, studentCourseSession, studentClass, studentAadharNo, addmissionFee, "S00" + IdGenerator.getSlipCode());

        if (studentHashMap.containsKey(studentModel.getStudentId())) {
            throw new CustomException("This Student is already exist record as per aadhar!.");
        }

        //getting a arraylist of className by roll number
        if (classByRollNoList.isEmpty()) {
            classModel = new ClassModel();
            rollNoList = new ArrayList<>();
            rollNoList.add(studentModel.getStudentId());
            classModel.setClassName(studentModel.getStudentClass());
            classModel.setClassList(rollNoList);
            classByRollNoList.add(classModel);

        } else {

            for (int k = 0; k < classByRollNoList.size(); k++) {
                if (classByRollNoList.get(k).getClassName().equals(studentModel.getStudentClass())) {
                    classModel = classByRollNoList.get(k);
                    isClassExist = true;
                }
            }
            if (isClassExist) {
                classModel.getClassList().add(studentModel.getStudentId());
                isClassExist = false;
            } else {
                //new model class create when no exist class
                classModel = new ClassModel();
                rollNoList = new ArrayList<>();
                rollNoList.add(studentModel.getStudentId());
                classModel.setClassName(studentModel.getStudentClass());
                classModel.setClassList(rollNoList);
                classByRollNoList.add(classModel);
            }
        }

        //if a new student getting addmission in vocation course
        studentHashMap.put(studentModel.getStudentId(), studentModel);
        studentList.add(studentModel);

        System.out.println("__________Successfully done of addmission process_______");

        return studentModel;
    }

    public ArrayList getAllVocationStudent() throws CustomException {
        if(studentList.isEmpty()){
            throw new CustomException("No Record Found!");
        }
        return studentList;
    }

    public ArrayList getListByCourse(String className) throws CustomException {

        if(classByRollNoList.isEmpty()){
            throw new CustomException("No Record Found");
        }
        ArrayList<ClassModel> classModelArrayList = new ArrayList();
        for (int i = 0; i < classByRollNoList.size(); i++) {
            if (classByRollNoList.get(i).getClassName().equals(className)) {
                classModelArrayList.add(classByRollNoList.get(i));
            }
        }
        ArrayList<StudentModel> getListByCourse = new ArrayList<>();
        for (int i = 0; i < classModelArrayList.get(0).getClassList().size(); i++) {
            int rollNoInsideInCourse = classModelArrayList.get(0).getClassList().get(i);
            StudentModel studentModel = studentHashMap.get(rollNoInsideInCourse);
            getListByCourse.add(studentModel);
        }
        return getListByCourse;
    }

    public StudentModel updateStudentRecord(int studentRollNo, StudentModel studentModel) throws Exception {

        if (!studentHashMap.containsKey(studentRollNo)) {
            throw new CustomException("No Student Record Found!!");
        }

        return studentModel;
    }

}
