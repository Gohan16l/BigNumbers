package com.core;

import BigNumbers.BN;
import java.util.Scanner;

public class Main {
	static Scanner tastiera = new Scanner(System.in);


	private static void stampa(String object)
	{
		System.out.println(object);
	}



	public static void main(String[] args) {
	// write your code here

		stampa("Primo numero:");
		BN a = new BN(tastiera.nextLine());
		stampa("Secondo numero:");
		BN b = new BN(tastiera.nextLine());

		//System.out.print(a.getS());
		//System.out.println(a.getOriginal());

		BN c = a.sum(b);

		System.out.print("risultato:");
		System.out.print(a.getS());
		System.out.println(c.getOriginal());
		stampa(String.valueOf("cifre usate:"+c.length()));
    }
}
