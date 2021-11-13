package module8;

import java.util.Random;

public class multiThreadedTest {
		private static int totalSum = 0;
		
		public static synchronized void totalSum(int value) {
	       	 multiThreadedTest.totalSum = multiThreadedTest.totalSum + value;
		}
	   
			   public static void main(String args[]) {
				   long startTime = System.currentTimeMillis();
				   Random rn = new Random();
				   int intArray[] = new int[200000000];
				   for (int o = 0; o < intArray.length; o++) {
				    	  intArray[o] = rn.nextInt(10) + 1;
				      }
				   
				   Thread t1 = new Thread (new Runnable() {
					   
					   @Override
					   public void run() {
						   for (int i = 0; i < 50000000; i++) {
							   totalSum(intArray[i]);
						   }
					   }
				   });
				   
				   Thread t2 = new Thread (new Runnable() {
					   
					   @Override
					   public void run() {
						   for (int i = 50000000; i < 100000000; i++) {
							   totalSum(intArray[i]);
						   }
					   }
				   });
				   
				   Thread t3 = new Thread (new Runnable() {
					   
					   @Override
					   public void run() {
						   for (int i = 100000000; i < 150000000; i++) {
							   totalSum(intArray[i]);
						   }
					   }
				   });
				   
				   Thread t4 = new Thread (new Runnable() {
					   
					   @Override
					   public void run() {
						   for (int i = 150000000; i < 200000000; i++) {
							   totalSum(intArray[i]);
						   }
					   }
				   });
				   t1.start();
				   t2.start();
				   t3.start();
				   t4.start();
				   
				   try {
					t1.join();
					t2.join();
					t3.join();
					t4.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   long totalTime = System.currentTimeMillis() - startTime;
				   System.out.println("Sum: " + multiThreadedTest.totalSum);
				   System.out.println("Time: " + totalTime/1000.0000);
			   }
			}


