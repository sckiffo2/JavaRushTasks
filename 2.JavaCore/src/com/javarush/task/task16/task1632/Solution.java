package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
    	ThreadOne one = new ThreadOne();
    	ThreadTwo two = new ThreadTwo();
		ThreadThree  three = new ThreadThree();
    	ThreadFour four = new ThreadFour();
		ThreadFive five = new ThreadFive();
		threads.add(one);
		threads.add(two);
		threads.add(three);
		threads.add(four);
		threads.add(five);
	}

    public static void main(String[] args) {



    }

    public static class ThreadOne extends Thread {
		@Override
		public void run() {
			int i = 0;
			while (true) {
				i++;
				i--;
			}
		}
	}

	public static class ThreadTwo extends Thread {
		@Override
		public void run() {
			try {
				Thread.sleep(999999999);
			} catch (InterruptedException e) {
				System.out.println("InterruptedException");
			}
		}
	}

	public static class ThreadThree extends Thread {
		@Override
		public void run() {
			while (!isInterrupted()) {
				try {
					System.out.println("Ура");
					Thread.sleep(500);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static class ThreadFour extends Thread implements Message {
		@Override
		public void showWarning() {
			interrupt();
		}

		@Override
		public void run() {
			while (!isInterrupted()) {

			}
		}
	}

	public static class ThreadFive extends Thread {
		@Override
		public void run() {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int sum = 0;
			String input;
			while (true) {
				input = "0";
				try {
					input = reader.readLine();
					sum += Integer.parseInt(input);
				} catch (IOException e) {
					continue;
				} catch (NumberFormatException e) {
					if (input.equals("N")) {
						break;
					}
				}
			}
			System.out.println(sum);
		}
	}
}