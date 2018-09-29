package com.pw.basic.callable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.pw.basic.RandomTest;
/**
 * 调用3次，会按照顺序返回值打印
 * @author Administrator
 *
 */
public class MCallable implements Callable<Map<String, String>> {
	private int num;

	public MCallable(int n) {
		this.num = n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 ExecutorService executor = Executors.newSingleThreadExecutor();//单线程
//		 ExecutorService executor = Executors.newFixedThreadPool(6);
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<Map<String, String>> result1 = executor.submit(new MCallable(1));
		Future<Map<String, String>> result2 = executor.submit(new MCallable(2));
		Future<Map<String, String>> result3 = executor.submit(new MCallable(3));
		executor.execute(new MRun());
		System.err.println("hello");
		try {
			System.err.println(result1.get().get("ss"));
			System.err.println(result2.get().get("ss"));
			System.err.println(result3.get().get("ss"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Map call() {
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int s = RandomTest.range(1, 3);
		System.err.println("call " + num + " " + s);
		Map map = new HashMap();
		map.put("ss", "xxxx" + s);

		return map;
	}
}