package org.oguz.multithreading.volatilethread;

import java.util.Scanner;

class Processor extends Thread
{

	private volatile boolean shutdown = false;


	@Override
	public void run()
	{

		while (!shutdown)
		{

			System.out.println("Hello");
			try
			{
				Thread.sleep(100);
			}
			catch (InterruptedException ex)
			{
				ex.printStackTrace();

			}
		}


	}
	
	public void shutdwon(){
		shutdown =true;
	}
}

public class App
{

	public static void main(String[] args)
	{
		Processor proc1 = new Processor();
		proc1.start();
		
		System.out.println("Press return to stop...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		proc1.shutdwon();

	}

}
