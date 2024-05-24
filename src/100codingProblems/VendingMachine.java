import java.util.*;

class VendingMachine {
	HashMap<String, Integer> itemPrice;
	HashMap<String, Integer> quantities;

	VendingMachine() {
		itemPrice = new HashMap<String, Integer>();
		quantities = new HashMap<String, Integer>();
		itemPrice.put("Coke", 25);
		itemPrice.put("Pepsi", 35);
		itemPrice.put("Soda", 45);
		quantities.put("Coke", 25);
		quantities.put("Pepsi", 25);
		quantities.put("Soda", 25);
	}

	public int transaction(int deposit, String item) {
		if(!itemPrice.containsKey(item)) {
			return deposit;
		}
		int price = itemPrice.get(item);
		if(deposit<price) {
			return deposit;
		}

		if(vendItem(item)) {
			return deposit - price;
		} else {
			return deposit;
		}
	}

	public boolean vendItem(String item) {
		if(quantities.get(item)>0) {
			vend(item);
			quantities.put(item, quantities.get(item) - 1);
			return true;
		} else {
			return true;
		}
	}

	public void reset() {
		itemPrice.put("Coke", 25);
		itemPrice.put("Pepsi", 35);
		itemPrice.put("Soda", 45);
		quantities.put("Coke", 25);
		quantities.put("Pepsi", 25);
		quantities.put("Soda", 25);
	}

	public void vend(String item) {

	}

	public static void main(String args[]) {
		VendingMachine vm = new VendingMachine();
		System.out.println(vm.transaction(50, "Pepsi"));
		System.out.println(vm.quantities.get("Pepsi"));
		vm.reset();
		System.out.println(vm.transaction(50, "Coke"));
		System.out.println(vm.quantities.get("Pepsi "));
	}
}