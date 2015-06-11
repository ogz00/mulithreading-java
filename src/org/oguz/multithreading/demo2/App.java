package org.oguz.multithreading.demo2;


class Runner implements Runnable
{
	@Override
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			System.out.println("Hello " + i);
			try
			{
				Thread.sleep(250);
			}
			catch (InterruptedException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}

public class App
{

	public static void main(String[] args)
	{
		Thread t1 = new Thread(new Runner());
		Thread t2 = new Thread(new Runner());

		t1.start();
		t2.start();

		// Another way:

		Thread t3 = new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				for (int i = 0; i < 10; i++)
				{
					System.out.println("Hello inside " + i);
					try
					{
						Thread.sleep(250);
					}
					catch (InterruptedException ex)
					{
						ex.printStackTrace();
					}

				}


			}
		});
		
		t3.start();

	}

}
