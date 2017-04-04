package com.lex.showcase.concurrency.temp;

public class ThreadDaemonTest {

	public static void main(String[] args) {
		Thread t1 = new MyCommon();
		Thread t2 = new Thread(new MyDaemon());
		t2.setDaemon(true); // 设置为守护进程
		
		t2.start();
		t1.start();
	}
}

class MyCommon extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("线程1第" + i + "次执行！");
			try {
				Thread.sleep(7);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class MyDaemon implements Runnable {

	@Override
	public void run() {
		for (long i = 0; i < 999999L; i++) {
			System.out.println("后台线程第" + i + "次执行！");
			try {
				Thread.sleep(7);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
