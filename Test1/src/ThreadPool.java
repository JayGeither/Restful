import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	public static void main(String[] args) {

		ExecutorService es = Executors.newFixedThreadPool(10);
		
		for(int i = 0; i < 10; i++) {
			es.submit(new Task(i));
		}
		
	}

}


class Task implements Runnable {
	private int id;

	public Task(int id) {
		this.id = id;
	}
	@Override
	public void run() {
		System.out.println("TaskId: " + this.id + " performd by " + Thread.currentThread().getName());
	}
	
	
	
}