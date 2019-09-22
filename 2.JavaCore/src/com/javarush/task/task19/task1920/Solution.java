package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {

		TreeMap<String, Double> salary = new TreeMap<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
			while (reader.ready()) {
				String line = reader.readLine();
				String name = line.split("\\s+")[0];
				Double money = Double.parseDouble(line.split("\\s+")[1]);
				if (salary.containsKey(name)) {
					double sum = salary.get(name) + money;
					salary.replace(name, sum);
				} else {
					salary.put(name, money);
				}
			}
		} catch (IOException e) {

		}

		double max = Double.MIN_VALUE;
		for(Map.Entry<String, Double> e : salary.entrySet()){
			if (e.getValue() > max) {
				max = e.getValue();
			}
		}

		for (Map.Entry<String, Double> e : salary.entrySet()) {
			if (e.getValue() == max) {
				System.out.println(e.getKey());
			}
		}
    }
}
