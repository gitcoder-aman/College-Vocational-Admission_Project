package util;

/* @TODO created by Aman Kumar (47)BCA III (2019-22)*/

public class IdGenerator {
    private static int rollNo = 0;
    private static int slipCode = 0;

    public static int getRollNo() {
        rollNo++;
        return rollNo;
    }
    public static int getSlipCode() {
        slipCode++;
        return slipCode;
    }
}