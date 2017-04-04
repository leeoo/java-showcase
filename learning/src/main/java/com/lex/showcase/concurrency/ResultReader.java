package com.lex.showcase.concurrency;

public class ResultReader extends Thread {
	Calculator calculator;
	
	public ResultReader(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void run() {
		synchronized (calculator) {
			try {
				System.out.println(Thread.currentThread() + "等待计算结果……");
				calculator.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread() + "计算结果为：" + calculator.total);
		}
	}
	
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		// 启动三个线程，分别获取计算结果
		new ResultReader(calculator).start();
		new ResultReader(calculator).start();
		new ResultReader(calculator).start();
		
		// 启动计算线程
		calculator.start();
	}
}
