package Thread;

import ExtendsThread.MyThread;

public class LambdaExpression {

	public static void main(String[] args) {
		int a = 0;
		Thread t1 = new Thread(() ->{
			System.out.println("Lambda çalışıyor.");
		});
		t1.start();
		for (int i = 0; i < 30; i++) {
			System.out.println(a);	
			a += 1;
		}
		
		
		
		MyThread t2 = new MyThread();
		t2.start();
		
		

	}

}
