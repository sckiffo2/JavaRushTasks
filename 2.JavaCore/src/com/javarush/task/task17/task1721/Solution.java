package com.javarush.task.task17.task1721;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		String firsFile = scan.nextLine();
		String secondFile = scan.nextLine();
		scan.close();
		Scanner firstFileScanner = new Scanner(new File(firsFile));
		Scanner secondFileScanner = new Scanner(new File(secondFile));
		Solution solution = new Solution();


		while (firstFileScanner.hasNext()) {
			allLines.add(firstFileScanner.nextLine());
		}

		while (secondFileScanner.hasNext()) {
			forRemoveLines.add(secondFileScanner.nextLine());
		}
		firstFileScanner.close();
		secondFileScanner.close();
		solution.joinData();

    }

    public void joinData() throws CorruptedDataException {
    	if (allLines.containsAll(forRemoveLines)) {
			allLines.removeAll(forRemoveLines);
    	} else {
			allLines.clear();
			throw new CorruptedDataException();
		}
    }
}
