package org.oguz.multithreading.demo1;


class Runner extends Thread{

	@Override
	public void run()
	{
		for(int i=0;i<10;i++){
			System.out.println("Hello "+ i);
			try{
				Thread.sleep(250);
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
	}
	
}

public class App
{
	public static void main(String arg[]){
		
		
		Runner run1 = new Runner();
		run1.start();
		
		
		Runner run2 = new Runner();
		
		run2.start();
		
	}

}
