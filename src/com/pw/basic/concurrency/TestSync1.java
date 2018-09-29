package com.pw.basic.concurrency;

/**
 * https://www.cnblogs.com/xrq730/p/6662232.html<br/>
 * 无效的同步锁案例 锁字符串，但在不是同一个字符串对象<br/>
 * 那么原因就在这里：尽管buildLock()方法构建出来的字符串都是"XXX-192.168.1.1"，<br/>
 * 但是由于StringBuilder的toString()方法每次都是new一个String出来，因此buildLock出来的对象都是不同的对象。
 * 
 * 
 * JVM内存区域里面有一块常量池，关于常量池的分配：
 * 
 * JDK6的版本，常量池在持久代PermGen中分配 JDK7的版本，常量池在堆Heap中分配
 * 字符串是存储在常量池中的，有两种类型的字符串数据会存储在常量池中：
 * 
 * 编译期就可以确定的字符串，即使用""引起来的字符串，比如String a = "123"、String b = "1" +
 * B.getStringDataFromDB() + "2" +
 * C.getStringDataFromDB()、这里的"123"、"1"、"2"都是编译期间就可以确定的字符串，因此会放入常量池，而B.getStringDataFromDB()、C.getStringDataFromDB()这两个数据由于编译期间无法确定，因此它们是在堆上进行分配的
 * 使用String的intern()方法操作的字符串，比如String b =
 * B.getStringDataFromDB().intern()，尽管B.getStringDataFromDB()方法拿到的字符串是在堆上分配的，但是由于后面加入了intern()，因此B.getStringDataFromDB()方法的结果，会写入常量池中
 * 常量池中的String数据有一个特点：每次取数据的时候，如果常量池中有，直接拿常量池中的数据；如果常量池中没有，将数据写入常量池中并返回常量池中的数据。
 * 
 * @author Administrator
 *
 */
public class TestSync1 {
	private static final int THREAD_COUNT = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread[] threads = new Thread[THREAD_COUNT];
		for (int i = 0; i < THREAD_COUNT; i++) {
			threads[i] = new Thread(new StringThread("192.168.1.1"));
		}

		for (int i = 0; i < THREAD_COUNT; i++) {
			threads[i].start();
		}

		for (;;)
			;
	}

}

class StringThread implements Runnable {

	private static final String LOCK_PREFIX = "XXX---";

	private String ip;

	public StringThread(String ip) {
		this.ip = ip;
	}

	@Override
	public void run() {
		String lock = buildLock();
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

	private String buildLock() {
		StringBuilder sb = new StringBuilder();
		sb.append(LOCK_PREFIX);
		sb.append(ip);

		String lock = sb.toString();
		System.out.println("[" + Thread.currentThread().getName() + "]构建了锁[" + lock + "]");

		return lock;
	}

}