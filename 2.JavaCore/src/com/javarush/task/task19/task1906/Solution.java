package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.util.ArrayList;

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


		try (
				FileReader reader = new FileReader(fileOne);
				FileWriter writer = new FileWriter(fileTwo)
		) {
			ArrayList<Integer> list = new ArrayList<>();

			while (reader.ready()){
				int data = reader.read();
				list.add(data);
			}

			for (int s = 0; s < list.size(); s++){
				if (s%2==1){
					writer.write(list.get(s));
				}
			}

		} catch (IOException e) {

		}
	}
}
