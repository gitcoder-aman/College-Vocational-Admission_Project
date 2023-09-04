package model;

import java.util.ArrayList;

public class ClassModel {
    String className;
    ArrayList<Integer>classList ;

    public ClassModel(String className, ArrayList<Integer> classList) {
        this.className = className;
        this.classList = classList;
    }

    public ClassModel() {
    }

    public String getClassName() {
        return className.toLowerCase();
    }

    public void setClassName(String className) {
        this.className = className.toLowerCase();
    }

    public ArrayList<Integer> getClassList() {
        return classList;
    }

    public void setClassList(ArrayList<Integer> classList) {
        this.classList = classList;
    }
}
