// Name: Vincent Wong
// NETID: VYW180000
// Sieve of Eratosthenes Program
//
// This program looks repeatedly and accepts any integer greater than or equal to two.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algorithm {

	//test
	public static void main(String[] args) throws IOException {
		// Get input using Buffered Reader class, then run sieve with user input
		
		//  boolean active = true; 
		//  while (active == true) { 
		//	  System.out.println("Enter integer greater than or equal to two (2): [Enter non-int to exit]"); 
		//	  BufferedReader reader = new BufferedReader(new
		//			  InputStreamReader(System.in)); 
		//	  String input = reader.readLine(); 
		//	  try { 
		//		  int intInput = Integer.parseInt(input); 
		//		  Algorithm.sieve(intInput); 
		//	  } 
		//	  catch (NumberFormatException e) {		  
		//		  active=false; 
		//		  System.out.println("Terminating program.");
		//	  }
		// }
		
		  // Run using given inputs
		  System.out.println("Run with n = -1");
		  Algorithm.sieve(-1);
		  System.out.println("Run with n = 1");
		  Algorithm.sieve(1);
		  System.out.println("Run with n = 5");
		  Algorithm.sieve(5);
		  System.out.println("Run with n = 10");
		  Algorithm.sieve(10);
		  System.out.println("Run with n = 100");
		  Algorithm.sieve(100);
		  System.out.println("Run with n = 1000");
		  Algorithm.sieve(1000);
		  
	}

	// Function based on the Sieve of Eratosthenes
	static void sieve(int n) {
		if (n < 2) {
			System.out.println("Index out of bounds. Please try again.");
			return;
		}

		// Increment n because Java is 0-based while our array is 1-based
		n++;

		// Create array "ray" of size n (ignoring 0 index)
		boolean[] ray = new boolean[n];

		// For loop to populate array with all true
		for (int b = 0; b < n; b++) {
			ray[b] = true;
		}

		/*
		 * Prints array before, testing code for (int k = 2; k < n; k++) { if (ray[k] ==
		 * true) System.out.print(k + " "); }
		 */

		// Sets int rootN as the square root of N, which will be the limit
		int rootN = (int) Math.sqrt(n);

		// For loop containing the bulk of the logic, checks all numbers and then
		// sets the composite index numbers to false
		for (int i = 2; i <= rootN; i++) {
			if (ray[i] == true) {
				for (int j = i * i; j < n; j += i) {
					ray[j] = false;
				}
			}
		}

		// Prints the prime numbers <= n
		// System.out.println();
		for (int k = 2; k < n; k++) {
			if (ray[k] == true)
				System.out.print(k + " ");
		}
		System.out.println("");
	}
}