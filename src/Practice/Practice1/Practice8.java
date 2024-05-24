import java.util.Random;
import java.util.HashMap;
class Practice8 {
	public static void main(String args[]) {
		Practice8 p = new Practice8();
		// String enc = "https://leetcode.com/problems/design-tinyurl";
		// String tiny = p.encode(enc);
		// System.out.println(tiny);
		// System.out.println(p.decode(tiny));

		for(int i=0; i<10; i++) {
			p.encodeRandom();
		}
		// }		

	}

	HashMap<Integer, String> urlMap = new HashMap<>();
    String baseUrl="http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int key = longUrl.hashCode();
        urlMap.put(key, longUrl);
        return baseUrl+key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urlMap.get(Integer.parseInt(shortUrl.substring(baseUrl.length())));
    }

    Random r = new Random();
    int key = 0; 
    HashMap<Integer, String> keyMap = new HashMap<>();

    public void encodeRandom() {
    	while(keyMap.containKey(key)) {
	    	key = r.nextInt(10);
    	}
    	keyMap.put(key,null);
    	System.out.println("next val is "+key);
    }
}

