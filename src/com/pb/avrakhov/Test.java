package com.pb.avrakhov;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String regex = "\\d{2}\\W\\d{2}\\W\\d{4}";
        String str = "30!11-1985";
        Boolean myCase = true;

        if(str.matches(regex)) {
            System.out.println(myCase);
        } else {
            myCase = false;
            System.out.println(myCase);
        }
    }
}
