package threads;

public class RunnableExample {
	public static void main(String[] args) {
		System.out.println("In main method");
		
		
		SampleThread st = new SampleThread();
	}
	
	
}

class SampleThread implements Runnable {

	
	@Override
	public void run() {
		System.out.println("This is running in thread");
	}
	
	public void startThread(){
		Thread t = new Thread(this, "first");
	}
	
}
