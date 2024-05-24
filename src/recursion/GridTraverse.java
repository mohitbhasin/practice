import java.util.Map;
import java.util.HashMap;

class GridTraverse {
	public static void main(String args[]) {
		// System.out.println(traverse(17, 17));
		System.out.println(traverseMemo(18 , 18, new HashMap<String, Long>()));
	}


	public static int traverse(int i, int j) {
		if(i==1 && j==1) {
			return 1;
		}

		if(i<1 || j<1) {
			return 0;
		}

		return traverse(i - 1, j) + traverse(i, j - 1);
	}

	public static Long traverseMemo(int i, int j, Map<String, Long> map) {
		String temp = i + "," +j;
		if(map.containsKey(temp) && map.get(temp)>1) {
			return map.get(temp);
		}

		if(i==1 && j==1) {
			return 1L;
		}

		if(i<1 || j<1) {
			return 0L;
		}

		map.put(temp, traverseMemo(i - 1, j, map) + traverseMemo(i, j - 1, map));

		return map.get(temp);
	}
}