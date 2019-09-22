package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		String path = consoleReader.readLine();

		FileInputStream fileInputStream = new FileInputStream(path);
		ArrayList<Integer> arrayList = new ArrayList<>();
		String nString = "";

		while (fileInputStream.available() > 0) {
			char c = (char)fileInputStream.read();
			if (c == '\r' || c == '\n') {
				c = 0;
				if (!nString.equals("")) {
					arrayList.add(Integer.parseInt(nString));
					nString = "";
				}

				continue;
			}
			nString += c;
		}
		fileInputStream.close();

		Collections.sort(arrayList);

		for (Integer integer : arrayList) {
			if (integer % 2 == 0) {
				System.out.println(integer);
			}
		}
    }
}
