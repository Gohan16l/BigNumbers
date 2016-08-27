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

		stampa("Run TEST Version 0.0.3.1 - BigNumbers library test");//-- KILLUA APPROVED

		stampa("First number:");
		BN a = new BN(tastiera.nextLine());
		stampa("Second number:");
		BN b = new BN(tastiera.nextLine());


		BN c;
		//System.out.print(a.getS());
		//System.out.println(a.getOriginal());

		stampa("select operation (+ - x ÷) :");
		switch (tastiera.next())
		{
			case "+" :c = a.sum(b); break;
			case "-": c = new BN(a.differenza(b)); break;
			default: stampa("Character not valid or work in progress"); c = new BN(); break;
		}




		BN d = new BN("0");

		System.out.print("result: \n");
		System.out.print(c.getS());
		System.out.println(BN.abs(c));
		stampa(String.valueOf("cifre usate:"+c.length()));
		stampa(String.valueOf("ID: "+d.getID()));
    }
}
