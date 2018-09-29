package com.pw.basic;

import javax.persistence.NonUniqueResultException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ExceptionTest {

	public static void main(String[] args) {
		
		JSONObject json = JSON.parseObject(null);
		
		// TODO Auto-generated method stub
		try {
			a();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

//		int s = b(2, 0);
//		System.out.println(s);

		try {
			c();
		} catch (NonUniqueResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("sss");
			e.printStackTrace();
		}
	}

	public static void a() throws Exception {
		throw new Exception("hello");
	}

	public static int b(int a, int b) {
		try {
			return a / b;
		} catch (java.lang.ArithmeticException e) {
			System.out.println("xxxxxxxxxxx");
			e.printStackTrace();
		}
		return 0;
	}

	public static void c() throws Exception {
		throw new javax.persistence.NonUniqueResultException();
	}
}
