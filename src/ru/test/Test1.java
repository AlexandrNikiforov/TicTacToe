package ru.test;

public class Test1 {

    public static void main(String[] args) {

        System.out.println( isSpaceFree(1));

    }
    static String space1 = "1 ";


    public static boolean isSpaceFree(int spaceNumber) {
        boolean spaceIsFree = false;
        if (spaceNumber == 1) {
            if (space1 == " ")
                spaceIsFree = true;
            else
                spaceIsFree = false;
        }
        return spaceIsFree;
    }
}