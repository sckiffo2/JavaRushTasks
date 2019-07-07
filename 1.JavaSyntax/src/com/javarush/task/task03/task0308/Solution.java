package com.javarush.task.task03.task0308;

/* 
Произведение 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
    	int composition = 1;
        for (int i = 1; i < 11; i++) {
			composition *= i;
		}
		System.out.println(composition);
    }
}
