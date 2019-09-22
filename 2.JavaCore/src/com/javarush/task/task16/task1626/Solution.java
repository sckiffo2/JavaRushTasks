package com.javarush.task.task16.task1626;

import java.sql.SQLOutput;

public class Solution {
    public static int number = 5;

    public static void main(String[] args) {
        new Thread(new CountdownRunnable(), "Уменьшаем").start();
        new Thread(new CountUpRunnable(), "Увеличиваем").start();
    }

    public static class CountUpRunnable implements Runnable {
        private int countToIndex = Solution.number;
        private int index = 0;

        public void run() {
			try {
				while (true) {
					index++;
					System.out.println(toString());
					Thread.sleep(500);
					if (index == countToIndex) {
						return;
					}
				}
			} catch (InterruptedException e) {
			}
		}


		public String toString() {
			return Thread.currentThread().getName() + ": " + index;
		}
	}


    public static class CountdownRunnable implements Runnable {
        private int countIndexDown = Solution.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}
