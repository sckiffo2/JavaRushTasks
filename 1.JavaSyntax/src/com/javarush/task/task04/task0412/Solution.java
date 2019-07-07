package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int arg = Integer.parseInt(reader.readLine());

        if (arg == 0)
            arg = 0;
        else if (arg < 0)
            arg++;
        else
            arg *= 2;

        System.out.println(arg);
    }

}