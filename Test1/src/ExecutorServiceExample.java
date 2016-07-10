import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService es = Executors.newSingleThreadExecutor();
		
		System.out.println("Passing callable task to calculate the value of factorial 10");
		Future<Long> futureObj = es.submit(new Factorial(10));
		
		
		System.out.println("Passing callable task to calculate the value of factorial 15");
		Future<Long> futureObj2 = es.submit(new Factorial(15));
		
		
		System.out.println("Passing callable task to calculate value of factorial 20");
		Future<Long> futureObj3 = es.submit(new Factorial(20));
		
		
		System.out.println("Calling get() method to fetch the result og factorial10");
		Long result =  futureObj.get();
		System.out.println(result);
		
		
		System.out.println("Calling get() method to fetch the result og factorial15");
		Long result2 = futureObj2.get();
		System.out.println(result2);
		
		System.out.println("Calling get() method to fetch the result og factorial20");
		Long result3 = futureObj3.get();
		System.out.println(result3);
		
	}

}


class Factorial implements Callable<Long> {

	private int num;
	public Factorial(int num) {
		this.num = num;
	}
	
	@Override
	public Long call() throws Exception {
		return fac(num);
	}

	private long fac(int n) throws InterruptedException{
		long result = 1;
		while(n != 0) {
			result = n * result;
			n = n -1;
			Thread.sleep(100);
		}
		return result;
			
	}
}