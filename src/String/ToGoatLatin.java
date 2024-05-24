import java.util.*;

class ToGoatLatin {
	public static void main(String args[]) {
		String sentence = "The quick brown fox jumped over the lazy dog";
		System.out.println(toGoatLatin(sentence));
	}

	public static String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        StringBuilder result = new StringBuilder();
        StringBuilder sb;
        StringBuilder alphaA = new StringBuilder("a");
        for(int i=0; i<words.length; i++) {
            sb = new StringBuilder(words[i]);
            if(vowels.contains(sb.charAt(0))) {
                sb.append("ma");
            } else {
                sb.append(sb.charAt(0));
                sb.deleteCharAt(0);
                sb.append("ma");
            }
            sb.append(alphaA);
            sb.append(" ");
            alphaA.append("a");
            result.append(sb.toString());
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }
}