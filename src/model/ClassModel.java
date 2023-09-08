package model;

import java.util.ArrayList;

public class ClassModel {
    String className;
    ArrayList<Integer> studentIdList = new ArrayList<>();
    Integer storeLastRollNo;

    public ClassModel(String className, ArrayList<Integer> studentIdList,Integer storeLastRollNo) {
        this.className = className;
        this.studentIdList = studentIdList;
        this.storeLastRollNo = storeLastRollNo;
    }

    public ClassModel() {
    }

    public Integer getStoreLastRollNo() {
        return storeLastRollNo;
    }

    public void setStoreLastRollNo(Integer storeLastRollNo) {
        this.storeLastRollNo = storeLastRollNo;
    }
    public String getClassName() {
        return className.toLowerCase();
    }

    public void setClassName(String className) {
        this.className = className.toLowerCase();
    }

    public ArrayList<Integer> getStudentIdList() {
        return studentIdList;
    }

    public void setStudentIdList(ArrayList<Integer> studentIdList) {
        this.studentIdList = studentIdList;
    }
}
