package com.javarush.task.task03.task0313;

/* 
Мама мыла раму
*/

public class Solution {
    public static void main(String[] args) {
        String[] words = {"Мама", "Мыла", "Раму"};
        String str;

        for (int i = 0; i < 3; i++) {
        	for (int j = 0; j < 3; j++) {
        		if (j != i)
        			for (int k = 0; k < 3; k++) {
        				if (k == j | k == i) continue;
        				str = words[i] + words[j] + words[k];
						System.out.println(str);
					}

			}
		}

    }
}
