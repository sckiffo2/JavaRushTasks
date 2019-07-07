package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {



		String writeString = "";
		try (FileReader reader = new FileReader(args[0])) {
			StringBuilder sb = new StringBuilder();
			while (reader.ready()) {
				sb.append((char)reader.read());
			}
			String[] words = sb.toString().split("\\s+");
			sb = new StringBuilder();
			for (int i = 0; i < words.length; i++) {
				if (words[i].matches(".*\\d.*")) {
					sb.append(" " + words[i]);
				}
			}
			writeString = sb.toString().trim();


		} catch (IOException e) {}

		try (FileWriter writer = new FileWriter(args[1])) {
			writer.write(writeString);
		} catch (IOException e) {}
    }
}

/*

D:\1.txt
D:\2.txt

 */
