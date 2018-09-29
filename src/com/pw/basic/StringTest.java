package com.pw.basic;

public class StringTest {
	public static void main(String[] args) {
		String s3 = "你好吗";
		String s4 = "你";
		String s5 = "好吗";

		System.out.println(s3 == ("你" + "好吗"));
		// 这个是true

		System.out.println(s4 + s5 == s3);
		// 这个是false
		
		System.out.println((s4+s5).intern()==s3);//true
	}
}
