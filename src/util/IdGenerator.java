package util;

/* @TODO created by Aman Kumar (47)BCA III (2019-22)*/

public class IdGenerator {
    private static int slipCode = 0;
    private static int studentId = 0;

    public static int getStudentId() {
        studentId++;
        return studentId;
    }
    public static int getSlipCode() {
        slipCode++;
        return slipCode;
    }
}