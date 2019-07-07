package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int max = Integer.MIN_VALUE;
        int temp;
        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(reader.readLine());
            if (temp > max) max = temp;
        }
        System.out.println(max);
    }
}
