package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
		try (BufferedReader r = new BufferedReader(new FileReader(args[0]))) {

			while (r.ready()) {
				String line = r.readLine();
				Matcher m = Pattern.compile("(\\D*)\\s(\\d{1,2}\\s\\d{1,2}\\s\\d{4})").matcher(line);
				m.find();
				String name = m.group(1);
				Date birthDate = new Date(Integer.parseInt(m.group(2).split(" ")[2]) - 1900, Integer.parseInt(m.group(2).split(" ")[1]) - 1, Integer.parseInt(m.group(2).split(" ")[0]));
				PEOPLE.add(new Person(name, birthDate));
			}
		} catch (IOException e) {}


		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		for (Person p: PEOPLE) {
			System.out.println(p.getName() + " " + sdf.format(p.getBirthDate()));
		}


    }
}
