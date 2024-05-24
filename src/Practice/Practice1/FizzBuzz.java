class FizzBuzz {
	public static void main(String args[]) {
		for(int i=1; i<=100; i++) {
			fizzOrBuzz(i);
		}
	}

	public static void fizzOrBuzz(int num) {
		if(num%3==0 && num%5==0) {
			System.out.println(num + " - FIZZBUZZ");
		}
		else if(num%3==0) {
			System.out.println(num + " - FIZZ");
		}
		else if(num%5==0) {
			System.out.println(num + " - Buzz");
		}
		else {
			System.out.println(num);
		}
	}
}