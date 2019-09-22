package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        int[][] mTable = new int[10][10];
        for(int i = 0;i < 10; i++) {
			for(int j = 0;j < 10; j++) {
				mTable[i][j] = (i + 1) * (j + 1);
			}
			System.out.print('\n');
		}
		for(int i = 0;i < 10; i++) {
			for(int j = 0;j < 10; j++) {
				System.out.print(mTable[i][j] + "\t");
			}
			System.out.print('\n');
		}
    }
}
