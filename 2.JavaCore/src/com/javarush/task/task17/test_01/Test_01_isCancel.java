package com.javarush.task.task17.test_01;

public class Test_01_isCancel {
	public static void main(String[] args)
	{
		Clock n = new Clock();

		Thread thread1 = new Thread(n);
		Thread thread2 = new Thread(n);
		thread1.start();
		thread2.start();

		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		n.cancel();

	}

	public static class Clock implements Runnable
	{
		private volatile boolean isCancel = false;

		public void cancel()
		{
			this.isCancel = true;
		}

		@Override
		public void run()
		{
			while (true)
			{

				try
				{   System.out.println(Thread.currentThread().getName()+" "+isCancel);
					Thread.sleep(2000);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
