package com.pw.basic;

public class LongTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Long s=22222L;
		Long ss = Long.valueOf("22222") ;
		
		Long a=127L;
		Long b=Long.valueOf("127");
		System.out.println(s==ss.longValue());//true
		System.out.println(s==ss);//false
		
		System.out.println(a==b.longValue());//true
		System.out.println(a==b);//true
		
	}

}
