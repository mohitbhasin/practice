import java.util.*;

class PascalTriangleLikeProblem {
	public static void main(String args[]) {
		String[] names = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};

		Map<String, List<String>> map = generate(names);

		for(String key: map.keySet()) {
			System.out.println(key+" ---> "+ map.get(key));
		}
	}

	public static Map<String, List<String>> generate(String[] names) {
		int parent=0; int index = 1;
		Map<String, List<String>> map = new HashMap<>();
		while(index<names.length) {
			List<String> vals = new ArrayList<>();

			for(int i=1; i<4 && index<names.length; i++) {
				vals.add(names[index++]);
			}
			map.put(names[parent++],vals);
		}
		return map;
	}
}