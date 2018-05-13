package problem.bucket;

public class Bucket {
	private int capacity;
	private int filled;
	
	public Bucket(int capacity) {
		this.capacity = capacity;
	}
	
	public boolean isEmpty() {
		if(filled==0) {
			return true;
		} else {
			return false;
		}
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getFilled() {
		return filled;
	}

	public void setFilled(int filled) {
		this.filled = filled;
	}
}
