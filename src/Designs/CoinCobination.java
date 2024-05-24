import java.util.*;

class CoinCobination {
	public static void main(String args[]) {		
		List<Integer> coinList = new ArrayList<Integer>();
		coinList.add(1);coinList.add(5);coinList.add(10);coinList.add(25);
		List<List<Integer>> result = new ArrayList<>();
		combSum(coinList, 15, new ArrayList<Integer>(), result, 0, 0);
		System.out.println(result);
		System.out.println(result.size());


	}
	public static void combSum(List<Integer> coinList, int target, List<Integer> curr, List<List<Integer>> result, int sum, int index) {
		if(sum==target) {
			result.add(new ArrayList<Integer>(curr));
			return;
		}
		if(sum>target) {
			return;
		}
		for(int i=index; i<coinList.size(); i++) {
			curr.add(coinList.get(i));
			combSum(coinList, target, curr, result, sum+coinList.get(i), i);
			curr.remove(curr.size() - 1);
		}
	}
}