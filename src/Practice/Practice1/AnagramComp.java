import java.util.HashMap;
import java.util.Arrays;
import java.util.List;

class AnagramComp {
	private String sortChars(String s) {
		char[] contents = s.toCharArray();
		Arrays.sort(contents);
		return contents.toString();
	}

	public static void main(String args[]) {
		String[] sentence = new String[] {"hello", "world", "wrldo", "hlleo", "wrold", "owrld", "olleh"};

		HashMap<String, List<String>> mapList = new HashMapList<String, List<String>>();

		for(String s: sentence) {
			String key = s.sortChars(s);
			if(mapList.get(key) !=null) {
				mapList.get(key).add(s);
			}
			mapList.put(key, s);
		}

		for(String k: mapList.keySet()) {
			System.out.println(mapList.get(k));
		}
	}
}