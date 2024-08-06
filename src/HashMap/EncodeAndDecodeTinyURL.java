import java.util.*;

class EncodeAndDecodeTinyURL {
	public static void main(String args[]) {
		VariableLengthEncoding object1 = new VariableLengthEncoding();
		String val1 = object1.encode("ajkhsdkjahsdkjs");
		System.out.println(val1+": "+object1.decode(val1));
		SimpleCounter object2 = new SimpleCounter();
		String val2 = object2.encode("ajkhsdkjahsdkjs");
		System.out.println(val2+": "+object2.decode(val2));
		RandomFixedLengthEncoding object3 = new RandomFixedLengthEncoding();
		String val3 = object3.encode("ajkhsdkjahsdkjs");
		System.out.println(val3+": "+object3.decode(val3));
	}


}
// Not Desireable
// - predictable
// - number of encoding dependent on range of int
// - length of url isn't quite short for later incoming longurls
class SimpleCounter {
	Map<Integer, String> map = new HashMap<>();
    int counter=0;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(counter, longUrl);
        return "http://tinyurl.com/"+counter++;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.substring(19)));
    }
}

// Not Desireable
// - keys are predictable
// - number of key generation are dependent on size of count which is of type int.
// - performance is good.
// - length of short url is not quite short in some cases.
class VariableLengthEncoding {
	Map<String, String> map = new HashMap<>();
    int count = 1;
    String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int curr = count;
        StringBuilder sb = new StringBuilder();
        while(curr>0) {
            curr--;
            sb.append(chars.charAt(curr%62));
            curr/=62;
        }
        map.put(sb.toString(), longUrl);
        sb.insert(0, "http://tinyurl.com/");
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.substring(19));
    }
}

// Desireable. 
// - number of urls that can be encoded is large(62^6).
// - fixed length of the key will make them consistent
// - unpredictable key generation for encoding
class RandomFixedLengthEncoding {
	Map<String, String> map = new HashMap<>();
    Random rand = new Random();
    String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public String getKey() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<6; i++) {
            sb.append(chars.charAt(rand.nextInt(62)));
        }
        return sb.toString();
    }
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = getKey();
        while(map.containsKey(key)) {
            key = getKey();
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/"+key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.substring(19));
    }
}