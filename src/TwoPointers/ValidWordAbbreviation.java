import java.util.*;

class ValidWordAbbreviation {
	public static void main(String args[]) {
		List<String[]> words = new ArrayList<>();
		words.add(new String[] {"obedience", "obe3nce"});
		words.add(new String[] {"algorithms", "algo5ms"});
		words.add(new String[] {"innovation", "in5ion"});
		words.add(new String[] {"h", "1"});
		words.add(new String[] {"z" , "2"});
		words.add(new String[] {"xjhoggxlgzjfwuwdyl" , "xj1og3gzj"});

		for(String[] pair: words) {
			System.out.println(validWordAbbreviation(pair[0], pair[1]));
		}
	}

	public static boolean validWordAbbreviation(String word, String abbr) {
        int i=0;
        int j=0;
        
        while(i<abbr.length()) {
          if(Character.isDigit(abbr.charAt(i))) {
            if(abbr.charAt(i)=='0') return false;
          	int count=0;
            while(i<abbr.length() && Character.isDigit(abbr.charAt(i))) {
              count*=10;
              count+=abbr.charAt(i) - '0';
              i++;
            }
            j+=count;
            if(j>word.length()) return false;
          }
          else if(abbr.charAt(i)!=word.charAt(j)) {
            return false;
          } else {
            i++;
            j++;
          }
        }
        return j==word.length();
      }
}