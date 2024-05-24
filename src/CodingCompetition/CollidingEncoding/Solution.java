import java.util.*;

class Solution {
    int[] mapping;
    Set<String> encodesSet;

    public static void main(String args[]) {
    	Solution obj = new Solution();
        Scanner scanner = new Scanner(System.in);
        int numTest = scanner.nextInt();
        for(int testCase=1; testCase<=numTest; testCase++) {
            // reading mapping
            int[] mappingInput = new int[26];
            for(int i=0; i<26; i++) {
                mappingInput[i] = scanner.nextInt();
            }
            // reading words
            int wordCount = scanner.nextInt();
            List<String> words = new ArrayList<>();
            for(int i=0; i<wordCount; i++) {
                words.add(scanner.next());
            }
            String result = obj.encodingCollisions(mappingInput, words)==false ? "NO" : "YES";
            System.out.println("Case #" + testCase + ": " + result);

        }
    }

    public boolean encodingCollisions(int[] encodingKeys, List<String> words) {
        mapping = encodingKeys;
        encodesSet = new HashSet<>();
        for(String word: words) {
            if(!encode(word)) {
                return true;
            }
        }
        return false;
    }

    public boolean encode(String word) {
        StringBuilder sb = new StringBuilder();
        for(char c: word.toCharArray()) {
            int index = c - 'A';
            sb.append(mapping[index]);
        }
        String encodedString = sb.toString();
        if(encodesSet.contains(encodedString)) {
            return false;
        }
        encodesSet.add(encodedString);
        return true;
    }
}