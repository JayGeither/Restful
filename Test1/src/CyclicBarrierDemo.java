import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static class Task implements Runnable {

		
		//This is an example
		CyclicBarrier barrier = new CyclicBarrier(3);

		public Task(CyclicBarrier barrier) {
			this.barrier = barrier;
		}

		@Override
		public void run() {

			try {
				System.out.println(Thread.currentThread().getName() + " waiting on barrier");
				barrier.await();
				System.out.println(Thread.currentThread().getName() + " croseed the barrier");
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {

			@Override
			public void run() {
				System.out.println("All threads reached the barrier, so let's play a game.");
			}
		});

		Thread t1 = new Thread(new Task(cb), "Thread1");

		Thread t2 = new Thread(new Task(cb), "Thread2");

		Thread t3 = new Thread(new Task(cb), "Thread3");

		t1.start();
		t2.start();
		t3.start();

	}
}
