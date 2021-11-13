package module8;

import java.util.Random;

public class concurrencyTest implements Runnable {
	private Thread t;
	private String threadName;
	
	public static synchronized int totalSum(int intArray[], int totalSum) {
		for(int i = 0; i < intArray.length; i++) {
       	 totalSum = totalSum + intArray[i];
	}
		return totalSum;
	}
	
	concurrencyTest (String name) {
		threadName = name;
		System.out.println("Creating " + threadName );
	}
	
	   public void run() {
		   long startTime = System.currentTimeMillis();
		      System.out.println("Running " +  threadName );
		      Random rn = new Random();
		      int intArray[] = new int[200000000];
		      int totalSum = 0;
		      for (int o = 0; o < intArray.length; o++) {
		    	  intArray[o] = rn.nextInt(10) + 1;
		      }
		      try {
		         totalSum = totalSum(intArray, totalSum);
		            Thread.sleep(50);
		            
		      } catch (InterruptedException e) {
		         System.out.println("Thread " +  threadName + " interrupted.");
		      }
		      long totalTime = System.currentTimeMillis() - startTime;
		      System.out.println("Thread " +  threadName + " exiting.");
		      System.out.println("Final Sum = " + totalSum);
		      System.out.println("Total Time = " + totalTime/1000.000 + " seconds.");
		      
		      
		   }
		   
		   public void start () {
		      System.out.println("Starting " +  threadName );
		      if (t == null) {
		         t = new Thread (this, threadName);
		         t.start ();
		      }
		   }
		   
		   public static void main(String args[]) {
			   
				  concurrencyTest R1 = new concurrencyTest( "Thread-1");
			      R1.start();
			      
			   }  
		}