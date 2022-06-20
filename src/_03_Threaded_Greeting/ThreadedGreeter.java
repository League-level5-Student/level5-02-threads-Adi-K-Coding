package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable {

	int x;

	public ThreadedGreeter(int x) {
		this.x = x;
	}

	

	public void run() {
		System.out.println("Hello from thread number: " + x);
		if (x < 50) {
			Thread t1 = new Thread(new ThreadedGreeter(x+1));
			t1.start();
			try {
				t1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
