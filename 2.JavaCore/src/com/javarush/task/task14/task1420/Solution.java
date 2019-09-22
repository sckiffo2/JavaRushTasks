package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int x;
		int y;
		int result;

		x = Integer.parseInt(reader.readLine());
		if (x <= 0)
			throw new Exception();
		y = Integer.parseInt(reader.readLine());
		if (y <= 0)
			throw new Exception();



		if (x < 0 || y < 0) {
			throw new NumberFormatException();
		}
		result = minDivider(x, y);
		System.out.println(result);


	}

	static int minDivider(int x, int y) {
    	int result = 0;

    	while(true) {
			if (x < y) {
				int temp = x;
				x = y;
				y = temp;
			} // swap if x < y

			if (x % y == 0) {
				result = y;
				break;
			} else {
				x = x % y;
			}
		}

    	return result;
	}
}
