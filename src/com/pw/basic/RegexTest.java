package com.pw.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "sasdf2323", b = "";
		Pattern p = Pattern.compile("(.*?)(\\d+)");
		Matcher m = p.matcher(b);
		if (m.find()) {
			System.out.println(m.groupCount());// 2
			// System.out.println(m.group(1));// 空
			System.out.println(m.group(2));// 23232
		} else {
			System.out.println("no found");
		}
		Long s=0l;
		System.err.println(s.toString());
		
		int youNumber = 10000;         
	    // 0 代表前面补充0         
	    // 4 代表长度为4         
	    // d 代表参数为正数型         
	    String str = String.format("%04d", youNumber);         
	    System.out.println(str);      

	}

}
