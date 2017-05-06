package com.core;

import BigNumbers.BN;

import java.util.Scanner;

/**
 *          This program is free software: you can redistribute it and/or modify
 *		    it under the terms of the GNU General Public License as published by
 *		    the Free Software Foundation, either version 3 of the License, or
 *		    any later version.
 *
 *		    This program is distributed in the hope that it will be useful,
 *		    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *		    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *		    GNU General Public License for more details.
 *
 *		    You should have received a copy of the GNU General Public License
 *		    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

public class Main {
	//inner variables
	private static Scanner keyboard = new Scanner(System.in);
	private static String version = "0.1.0.10" ;

	//methods
	private static <Type> void println(Type object)
	{
		System.out.println(object);
	}


	public static void main(String[] args) {

		println("Run TEST Version "+ version +" - BigNumbers library test");//-- KILLUA APPROVED

		//println(args[0]);

		println("First number:");
		BN A = new BN(keyboard.nextLine()); //create first BN object
		println("Second number:");
		BN B = new BN(keyboard.nextLine()); //create second BN object

		BN C; //declaration of C object

		long startTime; //it is used for timer
		println("select operation (+ - x ÷) :");
		switch (keyboard.next())
		{
			case "+": startTime = System.currentTimeMillis(); C = A.sum(B);  break; //sum operation with timer
			case "-": startTime = System.currentTimeMillis(); C = A.difference(B);  break; //difference operation with timer
			case "x": startTime = System.currentTimeMillis(); C = A.multiplication(B);  break; //multiplication operation with timer
			case "^": startTime = System.currentTimeMillis(); C = BN.pow(A,Long.decode(B.getNumber())); break; //pov operation with timer
			default: println("Character not valid or work in progress"); C = new BN("x"); startTime = System.currentTimeMillis(); break;
		}

		long finalTime = System.currentTimeMillis();

		//BN D = new BN(25.015181815115); //test with a number object


		System.out.print("result: \n"); //print a string with new line
		System.out.print(C.getS()); //print S of C object
		println(C.getNumber()); //print C value
		println(String.valueOf("digits used:" + C.length())); //print C length

		if ((((finalTime - startTime) / 1000) / 60) >= 60)//having time bigger than an hour
		{
			long hours = ((finalTime - startTime) / 1000) / 3600;
			long hs = hours * 60;
			long minutes = (((finalTime - startTime) / 1000) / 60) - hs;
			long ms = minutes * 60;
			long seconds = ((finalTime - startTime) / 1000) - ms;
			System.out.print("execution time: " + hours + " hours, " + minutes + " minutes and " + seconds + " seconds");
		}
		else if (((finalTime - startTime) / 1000) >= 60) //having time bigger than a minute
		{
			long minutes = ((finalTime - startTime) / 1000) / 60;
			long ms = minutes * 60;
			long seconds = ((finalTime - startTime) / 1000) - ms;
			System.out.print("execution time: " + minutes + " minutes and " + seconds + " seconds");
		}
		else //having time smaller than a minute
		{
			System.out.print("execution time: " + ((finalTime - startTime) / 1000) + " seconds");
		}

		println(" [ " + (finalTime - startTime)+ " milliseconds ] "+"\n" ); //print total time in milliseconds

	}
}
