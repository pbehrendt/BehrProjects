package documentationProject;

import java.util.Scanner;

public class documentationAssignment {
	
	public static int iterationEquation(int n) {
		/*Example for iteration method*/
		/*Create array to store numbers with 2 spare spots for n equal to 0 and 1*/
		int fib[] = new int[n+2];
		int i;
		/*Preset values for n equal to 0 and 1*/
		fib[0] = 0;
		fib[1] = 1;
		/*Start iteration two spots ahead because 0 and 1 are preset*/
		for(i = 2; i <= n; i++) {
		fib[i] = fib[i-1] + fib[i-2];
		}
	return fib[n];
	}
	
	public static int recursionEquation(int n) {
		/*Example for recursion method*/
		if (n <= 1) {/*In case of n equal to 0 or 1*/
			return n;
		}
		
		else {/*In cases of n being greater than 1*/
			return recursionEquation(n - 1) + recursionEquation(n - 2);
		}
		
	}
	
	public static void main (String args[]) {
		/*Declare new Scanner to get input for n*/
		Scanner scnr = new Scanner(System.in);
		
		/*Prompt user to enter number for Fibonacci equations*/
		System.out.println("Please enter an integer number: ");
		int n = scnr.nextInt();
		
		/*Print the equation value and total time for iteration method*/
		long startTime1 = System.nanoTime();
		System.out.println("Iteration: " + iterationEquation(n) + " " + (System.nanoTime() - startTime1));
		
		/*Print equation value and total time for recursion method*/
		long startTime2 = System.nanoTime();
		System.out.println("Recursion: " + recursionEquation(n) + " " + (System.nanoTime() - startTime2));
		
		/*Close the scanner*/
		scnr.close();
	}
}


