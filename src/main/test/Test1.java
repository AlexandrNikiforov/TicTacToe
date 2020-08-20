package main.test;

public class Test1 {

    public static void main(String[] args) {
        String values[] = {"1","X","3", "4","5","6", "7", "8","9"};
        System.out.println(isNumeric(values[0]));
        System.out.println(isNumeric(values[1]));


    }

    public static boolean isNumeric (String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}