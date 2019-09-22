package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
		String fileName1 = "";
		String fileName2 = "";
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			fileName1 = reader.readLine();
			fileName2 = reader.readLine();
		} catch (IOException e) {}

		ArrayList<String> fileOne = new ArrayList<>();
		ArrayList<String> fileTwo = new ArrayList<>();
		try (
				BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
				BufferedReader reader2 = new BufferedReader(new FileReader(fileName2))
		) {
			do {
				String string1 = reader1.readLine();
				if (string1 == null) {
					break;
				}
				fileOne.add(string1);
			} while (true);
			do {
				String string2 = reader2.readLine();
				if (string2 == null) {
					break;
				}
				fileTwo.add(string2);
			} while (true);
		} catch (IOException e) {}

		while (fileOne.size() > 0 && fileTwo.size() > 0) {
			if (fileOne.get(0).equals(fileTwo.get(0))) {
				lines.add(new LineItem(Type.SAME, fileOne.get(0)));
				fileOne.remove(0);
				fileTwo.remove(0);
			} else if (fileOne.get(1).equals(fileTwo.get(0))) {
				lines.add(new LineItem(Type.REMOVED, fileOne.get(0)));
				fileOne.remove(0);

			} else if (fileOne.get(0).equals(fileTwo.get(1))) {
				lines.add(new LineItem(Type.ADDED, fileTwo.get(0)));
				fileTwo.remove(0);
			}
		}
		if (fileOne.size() > fileTwo.size()) {
			lines.add(new LineItem(Type.REMOVED, fileOne.get(0)));
			fileOne.remove(0);
		} else if (fileOne.size() < fileTwo.size()) {
			lines.add(new LineItem(Type.ADDED, fileTwo.get(0)));
			fileTwo.remove(0);
		}
		for (LineItem line : lines) {
			System.out.println(line.toString());
		}
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

		@Override
		public String toString() {
			return type.toString() + " " + line;
		}
	}
}
