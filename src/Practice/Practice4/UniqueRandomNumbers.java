class UniqueRandomNumbers {
	public static void main(String args[]) {
		Generator generator = new Generator(1,3);
		System.out.println(generator.generate());
		System.out.println(generator.generate());
		System.out.println(generator.generate());
		System.out.println(generator.generate());
		System.out.println(generator.generate());
		System.out.println(generator.generate());
		System.out.println(generator.generate());
		System.out.println(generator.generate());
		System.out.println(generator.generate());
		System.out.println(generator.generate());
	}
}

class Generator {
	int max;
	int[] nums;

	public Generator(int low, int high) {
		this.nums = new int[high - low + 1];
		this.max = nums.length - 1;
		for(int i=0; i<nums.length; i++) {
			nums[i]=low++;
		}
	}

	public int generate() {
		if(max<0) {
			max=nums.length-1;
		}
		int randIndex = (int) (Math.random() * max);
		int temp = nums[randIndex];
		nums[randIndex] = nums[max];
		nums[max]=temp;
		return nums[max--];
	}
}