package com.pw.basic;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		System.out.println("生成5-10的随机数");
		int[] nums = new int[6];
		for (int i = 0; i < 100000; i++) {
			int n = range(5, 10);
			System.out.println(n);
			nums[n - 5]++;
		}
		System.out.println(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println((i + 5) + " " + nums[i]);
		}
	}

	public static int range(int min, int max) {
		Random random = new Random();
		return random.nextInt(max) % (max - min + 1) + min;
	}
}
