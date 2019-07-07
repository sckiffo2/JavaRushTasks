package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
	private String sourceFile;
	private String destinationFile;
	private String dataBuffer;

	public Solution() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			this.sourceFile = reader.readLine();
			this.destinationFile = reader.readLine();
		} catch (IOException e) {
		}

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.readData();
		solution.processData();
		solution.writeData();

	}

	private void readData() {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
			while (reader.ready()) {
				sb.append(reader.readLine());
			}
		} catch (IOException e) {
		}
		dataBuffer = sb.toString();
	}

	private void processData() {
		dataBuffer = dataBuffer.replaceAll("\\p{Punct}|\\n", "");
	}

	private void writeData() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {
			writer.write(dataBuffer);
		} catch (IOException e) {
		}
	}
}
