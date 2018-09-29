package com.pw.basic.queue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueTest {
	private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

	public static void main(String[] args) {
		//启动读线程
		Thread readThread = new Thread(new ReadThread());
		readThread.start();
		//启动线程，每秒打印队列内容
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("队列内容：" + queue);
				}
			}
		}).start();

		for (int i = 0; i < 3; i++) {
			Thread writeThread = new Thread(new WriteThread());
			writeThread.start();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class ReadThread extends Thread {
		public void run() {
			try {
				while (true) {
					Thread.sleep(1000);
					Date date = new Date();
					System.out.println(
							"完成等待 " + queue.take() + " \t耗时：" + (new Date().getTime() - date.getTime()) + "ms");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class WriteThread extends Thread {
		public void run() {
			init().stream().forEach(x -> {
				try {
					System.out.println("放入队列\t" + x);
					queue.put(x);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
	}

	private static List<String> init() {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add("atom" + i);
		}
		return list;
	}
}
