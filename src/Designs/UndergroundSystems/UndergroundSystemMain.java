class UndergroundSystemMain {
	public static void main(String args[]) {
		UndergroundSystem obj = new UndergroundSystem();
		obj.checkIn(45,"Leyton",3);
		obj.checkIn(32,"Paradise",8);
		obj.checkIn(27,"Leyton",10);
		obj.checkOut(45,"Waterloo",15);
		obj.checkOut(27,"Waterloo",20);
		obj.checkOut(32,"Cambridge",22);
		System.out.println(obj.getAverageTime("Paradise","Cambridge"));
		System.out.println(obj.getAverageTime("Leyton","Waterloo"));
		obj.checkIn(10,"Leyton",24);
		System.out.println(obj.getAverageTime("Leyton","Waterloo"));
		obj.checkOut(10,"Waterloo",38);
		System.out.println(obj.getAverageTime("Leyton","Waterloo"));
	}
}