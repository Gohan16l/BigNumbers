package com.core;

import BigNumbers.BN;
import java.util.*;

public class Main {
	private static Scanner keyboard = new Scanner(System.in);


	private static void println(String object)
	{
		System.out.println(object);
	}

	public static void main(String[] args) {
	// write your code here

		println("Run TEST Version 0.0.3.2.1 - BigNumbers library test");//-- KILLUA APPROVED

		println("First number:");
		BN a = new BN(keyboard.nextLine());
		println("Second number:");
		BN b = new BN(keyboard.nextLine());


		BN c;
		//System.out.print(a.getS());
		//System.out.println(a.getOriginal());

		println("select operation (+ - x ÷) :");
		long startTime = System.currentTimeMillis();
		switch (keyboard.next())
		{
			case "+" :c = a.sum(b); break;
			case "-": c = new BN(a.difference(b)); break;
			default: println("Character not valid or work in progress"); c = new BN(); break;
		}

		long finalTime = System.currentTimeMillis();

		BN d = new BN("0");

		System.out.print("result: \n");
		System.out.print(c.getS());
		System.out.println(BN.abs(c));
		println(String.valueOf("digits used:"+c.length()));
		println(String.valueOf("ID: "+d.getID()));
		if (((finalTime - startTime) / 1000) >= 60)
		{
			long minutes = ((finalTime - startTime) / 1000) / 60;
			long ms = minutes * 60;
			long seconds = ((finalTime - startTime) / 1000) - ms;
			System.out.println("execution time: " + minutes + " minutes and " + seconds + " seconds");
		}
		else
		{
			System.out.println("execution time: " + ((finalTime - startTime) / 1000) + " seconds");
		}
	}
}
