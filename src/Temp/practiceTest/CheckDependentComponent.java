import java.util.*;

// Unverified
class CheckDependentComponent {
	public static void main(String args[]) {
		// char[][] comp = {
		// 	{'a','b'},
		// 	{'b','c'},
		// 	{'a','c'},
		// 	{'c','a'},
		// 	{'a','d'},
		// };

		char[][] comp = {
			{'a','b'},
			{'b','c'},
			{'b','e'},
			{'c','d'},
			{'e','d'},
		};
		System.out.println(checkDependency(comp));
	}

	public static boolean checkDependency(char[][] comp) {
		Map<Character, Set<Character>> depMap = new HashMap<>();
		Set<Character> compSet;
		Set<Character> uniqueComp = new HashSet<>();
		for(int i=0; i<comp.length; i++) {
			uniqueComp.add(comp[i][0]);
			uniqueComp.add(comp[i][1]);
			if(!depMap.containsKey(comp[i][1])) {
				compSet = new HashSet<>();
				compSet.add(comp[i][0]);
				depMap.put(comp[i][1], compSet);
			} else {
				compSet = depMap.get(comp[i][1]);
				compSet.add(comp[i][1]);
				depMap.put(comp[i][1], compSet);
			}
		}

		for(char key: depMap.keySet()) {
			System.out.println(key+": "+depMap.get(key));
		}
		char curr = comp[0][0];
		return helper(depMap, uniqueComp, curr);
	}

	public static boolean helper(Map<Character, Set<Character>> depMap, Set uniqueComp, Character comp) {
		System.out.println(uniqueComp);
		if(!uniqueComp.contains(comp)) {
			return false;
		}
		if(!depMap.containsKey(comp)) {
			return true;
		}
		uniqueComp.remove(comp);
		boolean independent = true;
		for(char val: depMap.get(comp)) {
			if(!helper(depMap, uniqueComp, val)) {
				independent = false;
				break;
			}
		}
		return independent;
	}


	// not tested
	public static boolean checkDependency2(char[][] comp) {
		Map<Character, Set<Character>> depMap = new HashMap<>();
		Set<Character> compSet;
		for(int i=0; i<comp.length; i++) {
			if(!depMap.containsKey(comp[i][1])) {
				compSet = new HashSet<>();
				compSet.add(comp[i][0]);
				depMap.put(comp[i][1], compSet);
			} else {
				compSet = depMap.get(comp[i][1]);
				compSet.add(comp[i][1]);
				depMap.put(comp[i][1], compSet);
			}
		}

		Map<Character, Integer> compCount = new HashMap<>();

		for(int i=0; i<comp.length; i++) {
			if(!compCount.containsKey(comp[i][0])) {
				compCount.put(comp[i][0], 1);
			} else {
				compCount.put(comp[i][0], compCount.get(comp[i][0]) + 1);
			}
		}

		Character indComp=null;

		for(int i=0; i<comp.length; i++) {
			if(compCount.containsKey(comp[i][1])) {
				indComp=comp[i][1];
			}
		}

		if(indComp==null) {
			return false;
		}

		

		return true;

	}
}