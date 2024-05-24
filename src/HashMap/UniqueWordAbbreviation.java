import java.util.*;

class UniqueWordAbbreviation {
	public static void main(String args[]) {
		ValidWordAbbr obj = new ValidWordAbbr(new String[] {"deer","door","cake","card"});
		String[] words = {"dear","door","cart","cake"};

		for(String word: words) System.out.println(obj.isUnique(word));

	}
}

class ValidWordAbbr {
    Map<String, Set<String>> map;
        
    public ValidWordAbbr(String[] dictionary) {
        this.map = new HashMap<>();
        for(String word: dictionary) {
            String key = word.length()<3 ? word : ""+word.charAt(0)+(word.length()-2)+word.charAt(word.length()-1);
            if(!map.containsKey(key)) map.put(key, new HashSet<>());
            map.get(key).add(word);
        }
    }
    
    public boolean isUnique(String word) {
        String key = word.length()<3 ? word : ""+word.charAt(0)+(word.length()-2)+word.charAt(word.length()-1);
        if(map.containsKey(key)) {
            Set<String> set = map.get(key);
            return set.size() == 1 && set.contains(word);
        }
        return true;
    }
}