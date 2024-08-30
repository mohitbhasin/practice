class ConstantInsertRemoveRandomMain {
	public static void main(String args[]) {
		ConstantInsertRemoveRandom obj = new ConstantInsertRemoveRandom();
		
		System.out.println(obj.getRandom());
		obj.insert(3);
		obj.insert(5);
		obj.insert(13);
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		obj.remove(5);
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
	}
}