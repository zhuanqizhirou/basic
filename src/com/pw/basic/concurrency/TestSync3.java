package com.pw.basic.concurrency;

/**
 * https://www.cnblogs.com/xrq730/p/6662232.html 正确的
 * 
 * @author Administrator
 *
 */
public class TestSync3 {
	private static final int THREAD_COUNT = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread[] threads = new Thread[THREAD_COUNT * 2];
		for (int i = 0; i < THREAD_COUNT; i++) {
			threads[2 * i] = new Thread(new StringThread3("192.168.1.1"));
			threads[2 * i + 1] = new Thread(new StringThread3("192.168.1.2"));
		}

		for (int i = 0; i < THREAD_COUNT * 2; i++) {
			threads[i].start();
		}

		for (;;)
			;
	}

}

class StringThread3 implements Runnable {

	private static final String LOCK_PREFIX = "XXX---";

	private String ip;

	public StringThread3(String ip) {
		this.ip = ip;
	}

	@Override
	public void run() {
		String lock = buildLock();
		System.out.println("lock:"+lock);
		synchronized (lock) {
			System.out.println("[" + Thread.currentThread().getName() + "]开始运行了");
			// 休眠5秒模拟脚本调用
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("[" + Thread.currentThread().getName() + "]结束运行了");
		}
	}

	// [Thread-0]构建了锁[XXX---192.168.1.1]
	// [Thread-0]开始运行了
	// [Thread-1]构建了锁[XXX---192.168.1.1]
	// [Thread-2]构建了锁[XXX---192.168.1.1]
	// [Thread-3]构建了锁[XXX---192.168.1.1]
	// [Thread-4]构建了锁[XXX---192.168.1.1]
	// [Thread-0]结束运行了
	// [Thread-4]开始运行了
	// [Thread-4]结束运行了
	// [Thread-3]开始运行了
	// [Thread-3]结束运行了
	// [Thread-2]开始运行了
	// [Thread-2]结束运行了
	// [Thread-1]开始运行了
	// [Thread-1]结束运行了
	private String buildLock() {
		StringBuilder sb = new StringBuilder();
		sb.append(LOCK_PREFIX);
		sb.append(ip);
		String lock = sb.toString().intern();
//		System.out.println("[" + Thread.currentThread().getName() + "]构建了锁[" + lock + "]");

		return lock;
	}

}