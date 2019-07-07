package com.javarush.task.task19.task1904;



import java.io.IOException;
import java.nio.file.FileStore;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
		private final Scanner fileScanner;

		public PersonScannerAdapter(Scanner fileScanner) {
			this.fileScanner = fileScanner;
		}

		@Override
		public Person read() throws IOException {
			String[] personData = fileScanner.nextLine().split(" ", 4);
			Date birthDate = null;
			try {
				birthDate = new SimpleDateFormat("dd MM yyyy").parse(personData[3]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Person person = new Person(personData[1], personData[2], personData[0], birthDate);
			return person;
		}

		@Override
		public void close() throws IOException {
			fileScanner.close();
		}
	}
}
