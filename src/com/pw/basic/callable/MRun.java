package com.pw.basic.callable;

public class MRun implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.currentThread().sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("This is MRun");
	}
	
}