package com.pw.basic.thread;

import java.util.Iterator;
import java.util.Map;

public class MThreadUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countThread();
	}

	public static void countThread() {
		ThreadGroup group = Thread.currentThread().getThreadGroup();
		ThreadGroup topGroup = group;

		// 遍历线程组树，获取根线程组 （加上这段那么与方法2效果一样）
		// while (group != null) {
		// topGroup = group;
		// group = group.getParent();
		// }

		// 激活的线程数再加一倍，防止枚举时有可能刚好有动态线程生成
		int slackSize = topGroup.activeCount() * 2;
		Thread[] slackThreads = new Thread[slackSize];
		// 获取根线程组下的所有线程，返回的actualSize便是最终的线程数
		int actualSize = topGroup.enumerate(slackThreads);
		Thread[] atualThreads = new Thread[actualSize];
		// 复制slackThreads中有效的值到atualThreads
		System.arraycopy(slackThreads, 0, atualThreads, 0, actualSize);
		// System.out.println(Thread.currentThread().getThreadGroup().activeCount());
		// System.out.println(Thread.getAllStackTraces().size());
		System.out.println("方法1-----------");
		System.out.println("Threads size is " + atualThreads.length);
		for (Thread thread : atualThreads) {
			System.out.println("Thread name : " + thread.getName());
		}

		System.out.println("方法2-----------");

		Map map = Thread.getAllStackTraces(); // 也可以map<Thread, StackTraceElement[]>
		System.out.println("当前线程数：" + map.size());
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			Thread t = (Thread) it.next(); //
			System.out.println("Thread name : " + t.getName());
		}

		System.out.println("方法2 end--------");
	}
}
/*
方法1-----------
方法2-----------
Threads size is 1
Thread name : main
当前线程数：5
Thread name : Attach Listener
Thread name : Reference Handler
Thread name : Signal Dispatcher
Thread name : main
Thread name : Finalizer
方法2 end--------
*/
