package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Solution {
	private String fileOne;
	private String fileTwo;

	public Solution() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			this.fileOne = reader.readLine();
			this.fileTwo = reader.readLine();
		} catch (IOException e) {

		}
	}

    public static void main(String[] args) {
		new Solution().doWork();
    }

	public void doWork() {
		StringBuilder sb = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new FileReader(fileOne))){
			while (reader.ready()) {
				sb.append(reader.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] inputData = sb.toString().split(" ");
		sb = new StringBuilder();
		for (int i = 0; i < inputData.length; i++) {
			if (inputData[i].matches("\\d*")) {
				sb.append(inputData[i] + " ");
			}
		}


		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileTwo))) {
			writer.write(sb.toString().trim());

		} catch (IOException e) {

		}


	}
}
