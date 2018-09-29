package com.pw.basic.concurrency;
/**
 * https://blog.csdn.net/jintiaozhuang/article/details/54927238
 * 实现全局锁：锁住类的class对象。
 * static synchronized方法也相当于全局锁，相当于锁住了代码段。
 * @author Administrator
 *
 */
public class TestSynchronized3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			Thread thread = new MyThread3();
			thread.start();
		}
	}

}
class Sync3 {
	public void test() {
		synchronized (Sync3.class) {//实现了全局锁的效果
			System.out.println("test开始..");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("test结束..");
		}
	}
}
 
class MyThread3 extends Thread {
 
	public void run() {
		Sync3 sync = new Sync3();
		sync.test();
	}
}
 
