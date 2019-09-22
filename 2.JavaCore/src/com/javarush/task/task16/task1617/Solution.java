package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();


    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
			try {
				while (!this.isInterrupted()) {
					if (numSeconds > 0) {
						System.out.print(numSeconds + " ");
					}
					Thread.sleep(1000	);
					numSeconds--;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				if (numSeconds > 0) {
					System.out.print("Прервано!");
				} else if (numSeconds == 0) {
					System.out.print("Марш!");
				}
			}
		}
    }
}
