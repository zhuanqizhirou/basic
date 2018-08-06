package com.pw.basic;

public class Double {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		if (true) {
			throw new RuntimeException("Error");
		}
		System.out.println("after throw RuntimeException");
		throw new Exception("Error");

		// Unreachable code
		// System.out.println("after throw RuntimeException");
	}
}
