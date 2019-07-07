package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int days;
        int year = Integer.parseInt(reader.readLine());
        if (year % 400 == 0)
            days = 366;
        else if (year % 100 == 0)
            days = 365;
        else if (year % 4 == 0)
            days = 366;
        else
            days = 365;
        System.out.println("количество дней в году: " + days);
    }
}