package org.oguz.multithreading.synchronize;

public class App
{
	private volatile int count = 0;
	
	public synchronized void increment(){
		count++;
	}

	public static void main(String[] args)
	{

		App app = new App();
		app.doWork();


	}

	public void doWork()
	{

		Thread t1 = new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				for (int i = 0; i < 10000; i++)
				{

					increment();
					//System.out.println("1/ "+count);
				}

			}
		});
		Thread t2 = new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				for (int i = 0; i < 10000; i++)
				{
					increment();
					//System.out.println("2/"+count);
				}

			}
		});


		t1.start();
		t2.start();

		try
		{
			t1.join();
			t2.join();
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		System.out.println("count is : " + count);

	}

}
