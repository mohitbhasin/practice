import java.util.*;

class RepeatedDNASequences {
	public static void main(String args[]) {
		String[] dnaArray = {"ACCAC","GAGTCACAGTAGTTTCA", "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"};
		int[] kCount = {2,3,9};

		for(int i=0; i<dnaArray.length; i++) {
			System.out.println(findRepeatedDnaSequences(dnaArray[i]));
			System.out.println(polynomial_optimizedExponential(dnaArray[i], kCount[i]));
			System.out.println("----------------");
		}
	}

	public static List<String> findRepeatedDnaSequences(String s) {
        if(s.length()<10) return new ArrayList<>();
        Set<String> result = new HashSet<>();
		Set<Integer> hashes = new HashSet<>();
    	Map<Character, Integer> constMap = new HashMap<>();
        int k = 10;
    	constMap.put('A', 1);
    	constMap.put('C', 2);
    	constMap.put('G', 3);
    	constMap.put('T', 4);
    	int constant = 4;
    	int left = 0;
    	int hashValue = 0;
    	//calculating initial hash
    	for(int i=0; i<k; i++) {
    		hashValue+=constMap.get(s.charAt(i))*(int) Math.pow(constant, k-i-1);
    	}
    	hashes.add(hashValue);
    	int expoVal = (int) Math.pow(constant, k-1);
    	for(int i=k; i<s.length(); i++) {
    		//remove left character's hash
    		hashValue-=constMap.get(s.charAt(i-k))*expoVal;
    		// adjust hashValue of remaining characters
    		hashValue*=constant;
    		// add the hash of the current character (currVal * constant^0)
    		hashValue+=constMap.get(s.charAt(i));
    		if(!hashes.contains(hashValue)) {
    			hashes.add(hashValue);
    		} else {
    			result.add(s.substring(i-k+1, i+1));
    		}
    	}
		return new ArrayList<>(result);
    }


    public static Set<String> polynomial_optimizedExponential(String dna, int k) {
		Set<String> result = new HashSet<>();
		if(k>dna.length()) return result;
		Set<Integer> hashes = new HashSet<>();
    	Map<Character, Integer> constMap = new HashMap<>();

    	constMap.put('A', 1);
    	constMap.put('C', 2);
    	constMap.put('G', 3);
    	constMap.put('T', 4);
    	int constant = 4;
    	int left = 0;
    	int hashValue = 0;
    	//calculating initial hash
    	for(int i=0; i<k; i++) {
    		hashValue+=constMap.get(dna.charAt(i))*(int) Math.pow(constant, k-i-1);
    	}
    	hashes.add(hashValue);
    	int expoVal = (int) Math.pow(constant, k-1);
    	for(int i=k; i<dna.length(); i++) {
    		//remove left character's hash
    		hashValue-=constMap.get(dna.charAt(i-k))*expoVal;
    		// adjust hashValue of remaining characters
    		hashValue*=constant;
    		// add the hash of the current character (currVal * constant^0)
    		hashValue+=constMap.get(dna.charAt(i));
    		if(!hashes.contains(hashValue)) {
    			hashes.add(hashValue);
    		} else {
    			result.add(dna.substring(i-k+1, i+1));
    		}
    	}		
    	return result;
   }

    public static Set<String> slidingWindow_polynomial(String dna, int k) {
		Set<String> result = new HashSet<>();
		if(k>dna.length()) return result;
		Set<Integer> hashes = new HashSet<>();
    	Map<Character, Integer> constMap = new HashMap<>();

    	constMap.put('A', 1);
    	constMap.put('C', 2);
    	constMap.put('G', 3);
    	constMap.put('T', 4);
    	int constant = 4;
    	int left = 0;
    	int hashValue = 0;
    	//calculating initial hash
    	for(int i=0; i<k; i++) {
    		hashValue+=constMap.get(dna.charAt(i))*(int) Math.pow(constant, k-i-1);
    	}
    	hashes.add(hashValue);
    	for(int i=k; i<dna.length(); i++) {
    		//remove left character's hash
    		hashValue-=constMap.get(dna.charAt(i-k))*(int) Math.pow(constant, k-1);
    		// adjust hashValue of remaining characters
    		hashValue*=constant;
    		// add the hash of the current character (currVal * constant^0)
    		hashValue+=constMap.get(dna.charAt(i));
    		if(!hashes.contains(hashValue)) {
    			hashes.add(hashValue);
    		} else {
    			result.add(dna.substring(i-k+1, i+1));
    		}
    	}
		return result;
   }

    public static Set<String> slidingWindow_naive(String dna, int k) {
		Set<String> compareSet = new HashSet<>();
		Set<String> result = new HashSet<>();

		for(int i=k; i<=dna.length(); i++) {
			String sub = dna.substring(i-k, i);
			if(!compareSet.contains(sub)) {
			  compareSet.add(sub);
			} else 
				result.add(sub);
			}
		return result;
   }
}