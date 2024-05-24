import java.util.*;

class SimpleDictionary {
	// Elements are sorted automatically
	public static void main(String args[]) {
	    Map<String, Set<String>> dictionary = new TreeMap<>();
	    Set<String> a = new TreeSet<>(Arrays.asList("Actual", "Arrival", "Actuary"));
	    Set<String> b = new TreeSet<>(Arrays.asList("Bump", "Bravo", "Basic"));

	    dictionary.put("B", b);
	    dictionary.put("A", a);

	    System.out.println(dictionary);
	}
}