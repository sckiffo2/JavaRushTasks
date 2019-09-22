package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
		ArrayList<String>[] array = new ArrayList[4];
		for (int i = 0; i < array.length; i++) {
			array[i] = new ArrayList<>();
			for (int j = 0; j < 4; j++) {
				array[i].add("String " + i + " " + j);
			}
		}
        return array;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}