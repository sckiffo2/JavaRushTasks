package com.javarush.task.task10.task1012;

import java.awt.font.FontRenderContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

		HashMap<Character, Integer> map = new HashMap<>();
		for (Character c : alphabet) {
			map.put(c, 0);
		}

		for (String s : list) {
			char[] chars = s.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				char aChar = chars[i];
				if (alphabet.contains(aChar)) {
					map.put(aChar, map.get(aChar)+1);
				}
			}
		}

		for (Character c : alphabet) {
			String str = c + " " + map.get(c);
			System.out.println(str);
		}
    }

}
