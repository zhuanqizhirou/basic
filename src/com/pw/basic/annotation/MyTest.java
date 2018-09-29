package com.pw.basic.annotation;

public class MyTest {
	@MyAnnotation(hello = "hello,Qingdao", world = "Hello,world")
	public void output() {
		System.out.println("method output is running ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
