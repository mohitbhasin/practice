import java.util.*;

class FindAllAnagrams {
    public static void main(String args[]) {
        // String s = "cbaebabacd";
        // String p = "abc";
        String s = "abab";
        String p = "ab";

        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int i=0;
        char[] pChars = p.toCharArray();
        Arrays.sort(pChars);
        String pString = new String(pChars);
        
        while(i<=s.length()-p.length()) {
            if(isAnagram(i, s, pString)) {
                result.add(i);
            }
            i++;
        }
        
        return result;
    }
    
    public static boolean isAnagram(int index, String s, String pString) {
        char[] sChars = s.substring(index, index+pString.length()).toCharArray();
        Arrays.sort(sChars);
        String Ssorted = new String(sChars);
        return pString.equals(Ssorted);
    }
}