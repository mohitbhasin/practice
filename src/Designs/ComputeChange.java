class ComputeChange {
	public static void main(String args[]) {
		// Scanner input = new Scanner(System.in);

		// System.out.println("Enter the amount");
		// double amount = input.nextDouble(); //14.39
		double amount = 11.56;
		int remaining = (int) (amount * 100);
		//Dollars 
		System.out.println("Dollars: "+ remaining/100);
		remaining%=100;
		//Quaters
		System.out.println("Quaters: "+ remaining/25);
		remaining%=25;
		//Dime
		System.out.println("Dime: "+ remaining/10);
		remaining%=10;
		//Nickle
		System.out.println("Nickle: "+ remaining/5);
		remaining%=5;
		//Pennies
		System.out.println("Pennies: "+ remaining);
	}

}