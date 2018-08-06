package com.pw.basic;

public class ThreadLocalTest {
	//为避免内存泄露，定义为private static
	private static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>() {
		protected Object initialValue() {
			System.out.println("调用get方法时，当前线程共享变量没有设置，调用initialValue获取默认值！");
			return null;
		}
	};

	public static void main(String[] args) {
		new Thread(new MyIntegerTask("integerTask 1")).start();
		new Thread(new MyIntegerTask("integerTask 2")).start();
		new Thread(new MyStringTask("stringTask 1")).start();
		new Thread(new MyStringTask("stringTask 2")).start();
	}

	public static class MyIntegerTask implements Runnable {
		private String name;

		MyIntegerTask(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 5; i++) {
				if (null == ThreadLocalTest.threadLocal.get()) {
					ThreadLocalTest.threadLocal.set(0);
					System.out.println("thread" + name + ":0");
				} else {
					int num = (int) ThreadLocalTest.threadLocal.get();
					ThreadLocalTest.threadLocal.set(num + 1);
					System.out.println("thread" + name + ":" + ThreadLocalTest.threadLocal.get());
					if (i == 3) {
						ThreadLocalTest.threadLocal.remove();
					}
				}

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

	}

	public static class MyStringTask implements Runnable {
		private String name;

		MyStringTask(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 5; i++) {
				if (null == ThreadLocalTest.threadLocal.get()) {
					ThreadLocalTest.threadLocal.set("a");
					System.out.println("thread" + name + ":a");
				} else {
					String num = (String) ThreadLocalTest.threadLocal.get();
					ThreadLocalTest.threadLocal.set(num + "a");
					System.out.println("thread" + name + ":" + ThreadLocalTest.threadLocal.get());
				}

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

	}
}
