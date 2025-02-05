import java.util.*;

class ReverseWordsInString {
	public static void main(String args[]) {
		List<String> sentences = new ArrayList<>();
		sentences.add(" We love Java ");
		sentences.add("1234 abc XYZ");
		sentences.add("You are amazing");
		sentences.add("Hello     World");
		sentences.add("Greeting123");
		sentences.add("We love Java ");

		for(String sentence: sentences) {
			System.out.println(reverseWords(sentence));
			System.out.println(reverseWords_clean(sentence));
		}
	}

	public static String reverseWords_clean(String sentence) {
		sentence = sentence.replaceAll("\\s", " ").trim();
		int start=0;
		int end=0;
		char[] str = sentence.toCharArray();
		strRev(str, 0, str.length-1);

		while(end<=str.length) {
			if(end==str.length || str[end]==' ') {
				strRev(str, start, end-1);
				start=end+1;
			}
			end++;
		}
		return new String(str);
	}

	public static void strRev(char[] str, int start, int end) {
		while(start<end) {
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}
	
	public static String reverseWords(String sentence) {
      StringBuilder sb = new StringBuilder(sentence);
      sb.reverse();
      
      int start=0;
      int end=0;
      while(sb.charAt(0)==' ') {
        sb.deleteCharAt(0);
      }
      while(sb.charAt(sb.length()-1)==' ') {
        sb.deleteCharAt(sb.length()-1);
      }
      start=end;
      while(end<sb.length()) {
        if(sb.charAt(end)==' ') {
          reverse(sb, start, end-1);
          while(sb.charAt(end)==' ') {
            sb.deleteCharAt(end);
          }
          sb.insert(end++, ' ');
          start=end;
        } else {
          end++;
        }
      }
      reverse(sb, start, end-1);
      return sb.toString();
    }
    
    public static void reverse(StringBuilder sb, int start, int end) {
      while(start<end) {
        char temp = sb.charAt(start);
        sb.setCharAt(start, sb.charAt(end));
        sb.setCharAt(end, temp);
        start++;
        end--;
      }
    }
}