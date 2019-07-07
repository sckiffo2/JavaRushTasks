package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
	public static void main(String[] args) throws IOException{

		FileReader file1 = new FileReader(args[0]);
		FileWriter file2 = new FileWriter(args[1]);
		String buffer = "";
		String[] array;
		boolean firstWord = true;

		while(file1.ready()) {
			buffer += (char)file1.read();
		}

		buffer = buffer.replaceAll(System.lineSeparator(), " ");
		array = buffer.split(" ");

		for (String pair : array) {
			if(pair.length() > 6){
				if(firstWord){
					file2.write(pair);
					firstWord = false;
				}else file2.write( "," + pair);
			}
		}

		file1.close();
		file2.close();
	}
}
