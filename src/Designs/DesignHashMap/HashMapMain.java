class HashMapMain {
	public static void main(String args[]) {
		HashMap map = new HashMap();
		map.put(1,1);
		map.put(2,2);
		System.out.println(map.get(1));
		System.out.println(map.get(3));
		map.put(2,1);
		System.out.println(map.get(2));
		map.remove(2);
		System.out.println(map.get(2));
	}
}