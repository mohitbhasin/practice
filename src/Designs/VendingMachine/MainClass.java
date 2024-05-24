import java.lang.reflect.*;

class MainClass extends Temp implements VendingMachine {
	public static void main(String args[]) {
		System.out.println("------");
		
		MainClass main = new MainClass();
		main.printClassName();
		main.setHealth();
		System.out.println(main.getNumber());
		System.out.println(main.methodName());

		Class c;
		Method m[];
	}

	@Override
	public void setHealth() {
		System.out.println("Set health method defined");
	}

	@Override
	public int getNumber() {
		return 100;
	}
	@Override
	public String methodName() {
		return "methodName - methodName";
	}
}