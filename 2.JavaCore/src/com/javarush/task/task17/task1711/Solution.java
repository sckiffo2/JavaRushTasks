package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
		switch (args[0]) {
			case ("-c"):
				synchronized (allPeople) {
					if ((args.length - 1) % 3 == 0) { // проверка на количество аргументов для циклической обработки
						for (int i = 1; i < args.length; i += 3) {
							Date date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i+2]);

							if (args[i+1].equals("м")) {
								allPeople.add(Person.createMale(args[i], date));
							} else {
								allPeople.add(Person.createFemale(args[i], date));
							}
							System.out.println(allPeople.size() - 1);
						}
					}
				}
				break;
			case ("-u"):
				synchronized (allPeople) {
					if ((args.length - 1) % 4 == 0) {
						for (int i = 1; i < args.length; i += 4) {
							Date date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i+3]);
							int id = Integer.parseInt(args[i]);
							allPeople.get(id).setName(args[i+1]);
							allPeople.get(id).setSex(args[i+2].equals("м") ? Sex.MALE : Sex.FEMALE);
							allPeople.get(id).setBirthDate(date);
						}

					}
				}
				break;
			case ("-d"):
				synchronized (allPeople) {
					for (int i = 1; i < args.length; i++) {
						int id = Integer.parseInt(args[i]);
						allPeople.get(id).setName(null);
						allPeople.get(id).setSex(null);
						allPeople.get(id).setBirthDate(null);
					}
				}
				break;
			case ("-i"):
				synchronized (allPeople) {
					for (int i = 1; i < args.length; i++) {
						int id = Integer.parseInt(args[i]);
						DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
						Date date = allPeople.get(id).getBirthDate();
						String output = allPeople.get(id).getName() +
								(allPeople.get(id).getSex().equals(Sex.MALE) ? " м " : " ж ") +
								df.format(date);
						System.out.println(output);
					}
				}
				break;
			default:
				synchronized (allPeople) {

				}
				break;
		}
    }
}
