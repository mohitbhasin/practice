import java.util.*;
import java.io.*;

class LongestRepeatingCharacterReplacement {
	public static void main(String args[]) {
		List<String[]> inputList = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader("LongestRepeatingCharacterReplacement.txt"))) {
			String line;
			while((line = br.readLine())!=null) {
				line = line.toUpperCase();
				inputList.add(line.split(" "));
			}
		} catch(IOException e) {
			System.out.println(e);
		}

		for(String[] input: inputList) {
			System.out.println("k="+input[0]+" "+input[1]+": "+characterReplacement(input[0], Integer.parseInt(input[1])));
		}

	}

	public static int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int result = 0;
        int[] freqs = new int[26];

        while(right<s.length()) {
            int curr = s.charAt(right) - 'A';
            freqs[curr]=freqs[curr]+1;
            maxFreq = Math.max(maxFreq, freqs[curr]);
            if((right-left+1 - maxFreq) > k) {
                freqs[s.charAt(left) - 'A']--;
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }

    public static int characterReplacement_hashmap(String s, int k) {
        int maxFreq = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int result = 0;
        int left = 0;
        int right = 0;

        while(right<s.length()) {
            char curr = s.charAt(right);
            freqMap.put(curr, 1 + freqMap.getOrDefault(curr, 0));
            maxFreq = Math.max(maxFreq, freqMap.get(curr));
            if((right-left+1 - maxFreq)>k) {
                freqMap.put(s.charAt(left), freqMap.get(s.charAt(left)) - 1);
                left++;
            }
            result = Math.max(result, right-left+1);
            right++;
        }
        return result;
    }
}