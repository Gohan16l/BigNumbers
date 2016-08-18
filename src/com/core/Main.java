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

		stampa("Run TEST Version 0.0.2.2 - BigNumbers library test");//-- KILLUA APPROVED

		stampa("Primo numero:");
		BN a = new BN(tastiera.nextLine());
		stampa("Secondo numero:");
		BN b = new BN(tastiera.nextLine());

		//System.out.print(a.getS());
		//System.out.println(a.getOriginal());

		BN c = a.sum(b);

		System.out.print("risultato:");
		System.out.print(c.getS());
		System.out.println(BN.abs(c));
		stampa(String.valueOf("cifre usate:"+c.length()));
		stampa(String.valueOf("ID:"+c.getID()));
    }
}
