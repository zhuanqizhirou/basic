package com.pw.basic.concurrency;

public class TestSynchronized2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sync sync = new Sync();
		for (int i = 0; i < 3; i++) {
			Thread thread = new MyThread2(sync);
			thread.start();
		}
	}

}
class MyThread2 extends Thread {
	private Sync sync;
 
	public MyThread2(Sync sync) {
		this.sync = sync;
	}
 
	public void run() {
		sync.test();
	}
}
 
