package com.core;

import BigNumbers.BN;

import java.util.Scanner;

public class Main {
	private static Scanner keyboard = new Scanner(System.in);


	private static void println(String object)
	{
		System.out.println(object);
	}

	public static void main(String[] args) {

		println("Run TEST Version 0.1.0.0 - BigNumbers library test");//-- KILLUA APPROVED

		//println(args[0]);

		println("First number:");
		BN a = new BN(keyboard.nextLine());
		println("Second number:");
		BN b = new BN(keyboard.nextLine());


		BN c;
		//System.out.print(a.getS());
		//System.out.println(a.getOriginal());

		long startTime;
		println("select operation (+ - x ÷) :");
		switch (keyboard.next())
		{
			case "+": startTime = System.currentTimeMillis(); c = a.sum(b);  break;
			case "-": startTime = System.currentTimeMillis(); c = a.difference(b);  break;
			case "x": startTime = System.currentTimeMillis(); c = a.multiplication(b);  break;
			case "^": startTime = System.currentTimeMillis(); c = BN.pow(a,Long.decode(b.getOriginal())); break;
			default: println("Character not valid or work in progress"); c = new BN(); startTime = System.currentTimeMillis(); break;
		}

		long finalTime = System.currentTimeMillis();

		BN d = new BN();
		try
		{
			d = new BN(25.015181815115);
		}

		if (BN.getCounter()==2)
		{
			d = new BN();
		}

		System.out.print("result: \n");
		System.out.print(c.getS());
		System.out.println(BN.abs(c));
		println(String.valueOf("digits used:"+c.length()));
		println(String.valueOf("ID: "+d.getID()+" (it must be 3!)"));

		if ((((finalTime - startTime) / 1000) / 60) >= 60)
		{
			long hours = (((finalTime - startTime) / 1000) / 60) /60;
			long hs = hours * 60;
			long minutes = (((finalTime - startTime) / 1000) / 60) - hs;
			long ms = minutes * 60;
			long seconds = ((finalTime - startTime) / 1000) - ms;
			System.out.print("execution time: " + hours + " hours, " + minutes + " minutes and " + seconds + " seconds");
		}
		else if (((finalTime - startTime) / 1000) >= 60)
		{
			long minutes = ((finalTime - startTime) / 1000) / 60;
			long ms = minutes * 60;
			long seconds = ((finalTime - startTime) / 1000) - ms;
			System.out.print("execution time: " + minutes + " minutes and " + seconds + " seconds");
		}
		else
		{
			System.out.print("execution time: " + ((finalTime - startTime) / 1000) + " seconds");
		}

		System.out.println(" [ " + (finalTime - startTime)+ " milliseconds ] "+"\n" );

	}
}
