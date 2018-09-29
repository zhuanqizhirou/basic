package com.pw.basic.concurrency;

/**
 * https://blog.csdn.net/jintiaozhuang/article/details/54927238
 * synchronized(this)以及非static的synchronized方法（至于static synchronized方法请往下看），<br/>
 * 只能防止多个线程同时执行同一个对象的同步代码段。
 * 
 * 答案是：synchronized锁住的是括号里的对象，而不是代码。<br/>
 * 对于非static的synchronized方法，锁的就是对象本身也就是this。
 * 
 * @author Administrator
 *
 */
class Sync {
	public synchronized void test() {
		System.out.println("test开始..");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("test结束..");
	}

	public void test2() {
		synchronized (this) {
			System.out.println("test 2开始..");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("test 2结束..");
		}
	}
}

class MyThread extends Thread {

	public void run() {
		Sync sync = new Sync();
		sync.test();
	}
}

public class TestSynchronized {

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			Thread thread = new MyThread();
			thread.start();
		}
	}
}
