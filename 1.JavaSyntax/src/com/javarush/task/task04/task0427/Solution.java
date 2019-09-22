package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int numb = Integer.parseInt(reader.readLine());
		if (numb < 1000 && numb > 0)
			if (isEven(numb) && numb/100 > 0)
				System.out.println("четное трехзначное число");
			else if (isEven(numb) && numb/10 > 0)
					System.out.println("четное двузначное число");
				else if (isEven(numb))
						System.out.println("четное однозначное число");
			if (!isEven(numb) && numb/100 > 0)
				System.out.println("нечетное трехзначное число");
			else if (!isEven(numb) && numb/10 > 0)
					System.out.println("нечетное двузначное число");
			else if (!isEven(numb))
						System.out.println("нечетное однозначное число");

	}

    static boolean isEven (int a) {
    	if (a % 2 == 0)
    		return true;
    	else
    		return false;
	}
}
