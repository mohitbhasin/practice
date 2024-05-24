import java.util.*;

class HashExample {
	static HashMap<String, Integer> map;
	public static void main(String args[]) {
		map = new HashMap<>();
		fillHashMap();
		// for(String key: map.keySet()) {
		// 	System.out.println(key+" - "+map.get(key));
		// }
		fitStringsInArray();

	}

	public static void printHashValue(String s) {
		System.out.println(s.hashCode());
	}

	public static void fillHashMap() {
		for(String s: getSampleStringSet()) {
			map.put(s, s.hashCode());
		}
	}

	public static String[] getSampleStringSet() {
		String[] s = {"James","Josephine","Art","Lenna","Donette","Simona","Mitsue","Leota","Sage","Kris","Minna","Abel","Kiley","Graciela","Cammy","Mattie","Meaghan","Gladys","Yuki","Fletcher","Bette","Veronika","Willard","Maryann","Alisha","Allene","Chanel","Ezekiel","Willow","Bernardo","Ammie","Francine","Ernie","Albina","Alishia","Solange","Jose","Rozella","Valentine","Kati","Youlanda","Dyan","Roxane","Lavera","Erick","Fatima","Jina","Kanisha","Emerson","Blair"};
		return s;
	}

	public static void fitStringsInArray() {
		String[] arr = new String[50];
		int n = arr.length;
		for(String s: map.keySet()) {
			int index = Math.abs(s.hashCode()) % n;
			if(arr[index]!=null) {
				System.out.println("Collision for - "+s);
			} else {
				arr[index] = s;
			}
		}

		for(int i=0; i<arr.length; i++) {
			System.out.println("index - "+i+" val - "+arr[i]);
		}
	}

	private static int generateHashCode(String s) {
		int hashCode = 0;
		for(char c: s.toCharArray()) {
			hashCode = 31 * hashCode + c; 
		}
		return hashCode;
	}
}