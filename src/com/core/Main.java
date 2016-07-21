package com.core;

import BigNumbers.BN;

public class Main {

    public static void main(String[] args) {
	// write your code here

		BN a = new BN("999");
		BN b = new BN("1");

		System.out.print(a.getS());
		System.out.println(a.getOriginal());

		BN c = a.sum(b);

		System.out.print(a.getS());
		System.out.println(c.getOriginal());
    }
}
