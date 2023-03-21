package day20;



class MyThread2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1; i<=200; i++) {
			System.out.printf("%d번째 %s\n",i, Thread.currentThread() );
		}
		
	}
	
}
public class ThreadEx02{
	public synchronized/*동기화하는 키워드*/ static void main(String[]args) {
		// Runnable로 구현하는 방법
		MyThread2 mth = new MyThread2();
		Thread th1 = new Thread(mth);
		th1.start();
		try {
			th1.join();//th2번 쓰레드 완료 후 진행
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		// 자신의 쓰레드를 객체로 만들어서 생성자로 선언해주는 방법
		Thread th2 = new Thread(new MyThread2());
		th2.start();
		try {
			th2.join(); //th2번 쓰레드 완료 후 진행
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		System.out.println("main end");
	}
}