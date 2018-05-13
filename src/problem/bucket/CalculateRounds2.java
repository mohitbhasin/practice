package problem.bucket;

public class CalculateRounds2 {
	public static void main(String args[]) {
		Bucket a = new Bucket(3);
		Bucket b = new Bucket(5);
		
		fillBuckets(a, b, 4);
	}
	
	public static void fillBuckets(Bucket a, Bucket b, int requiredQuant) {
		if(a.getFilled()==requiredQuant || b.getFilled()==requiredQuant) {
			System.out.println("Reached required quantity");
		}
		else {
			if (a.getFilled()==a.getCapacity()) {
				a.setFilled(0);
			}
			else {
				if(b.isEmpty()) {
					b.setFilled(b.getCapacity());
				} else {
					int requiredToFillA=a.getCapacity() - a.getFilled();
					int availableInB=b.getFilled();
					if(availableInB<=requiredToFillA) {
						a.setFilled(a.getFilled()+availableInB);
						b.setFilled(0);
					} else {
						a.setFilled(a.getCapacity());
						b.setFilled(b.getFilled()-requiredToFillA);
					}
				}
			}
			System.out.println("Bucket1 - " +a.getFilled() + " Bucket2 - " +b.getFilled());
			fillBuckets(a, b, requiredQuant);
		}
	}
}
