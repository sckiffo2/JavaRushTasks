package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> bigList = new ArrayList<>();
        ArrayList<Integer> byThree = new ArrayList<>();
        ArrayList<Integer> byTwo = new ArrayList<>();
        ArrayList<Integer> other = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 20; i++) {
			bigList.add(Integer.parseInt(reader.readLine()));
		}
		for (int i = 0; i < bigList.size(); i++) {
			int x = bigList.get(i);
			if (x % 3 == 0) {
				byThree.add(x);
			}
			if (x % 2 == 0) {
				byTwo.add(x);
			}
			if (x % 3 != 0 && x % 2 != 0) {
				other.add(x);
			}
		}
		printList(byThree);
		printList(byTwo);
		printList(other);

    }

    public static void printList(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
    }
}
