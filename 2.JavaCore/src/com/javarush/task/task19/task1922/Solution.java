package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
		String fileName = "";

		try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
			fileName = r.readLine();
		} catch (IOException e) {

		}

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			while (reader.ready()) {
				int reps = 0;
				String line = reader.readLine();
				String[] wordsLine = line.split(" ");

				for (int i = 0; i < wordsLine.length; i++) {
					if (words.contains(wordsLine[i])) {
						reps++;
					}
				}
				if (reps == 2) {
					System.out.println(line);
				}
			}
		} catch (IOException e) {

		}

    }
}
