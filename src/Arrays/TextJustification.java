import java.util.*;

class TextJustification {
	public static void main(String args[]) {
		// String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		// int maxWidth = 16;
		// String[] words = {"What","must","be","acknowledgment","shall","be"};
		// int maxWidth = 16;
		String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
		int maxWidth = 20;
		List<String> result = fullJustify(words, maxWidth);
		for(String sentence: result) {
			System.out.println(sentence);
		}
	}

	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<>();

		int baseLen = -1;
		int beginIndex = 0;
		int i=0;
		while(i<words.length) {
			if(baseLen+words[i].length()+1<=maxWidth) {
				baseLen+=words[i++].length()+1;
			}
			else {
				helper(words, beginIndex, i, result, baseLen, maxWidth);
				beginIndex=i;
				baseLen=-1;
			}
		}
		if(beginIndex!=i) helper(words, beginIndex, i, result, baseLen, maxWidth);
		return result;
	}

	public static void helper(String[] words, int beginIndex, int i, List<String> result, int baseLen, int maxWidth) {
		int wordCount = i - beginIndex - 1;
		if(wordCount==0 || i==words.length) {
			String temp = words[beginIndex++];
			while(beginIndex<i) temp+=" "+words[beginIndex++];
			result.add(temp+" ".repeat(maxWidth-baseLen));
			return;
		}
		int remainWidth = maxWidth - baseLen;
		int spacePerWord = remainWidth/wordCount + 1;
		int extraSpace = remainWidth%wordCount;

		StringBuilder sb = new StringBuilder();

		while(beginIndex<i-1) {
			if(extraSpace>0) {
				sb.append(words[beginIndex++]+" ".repeat(spacePerWord+1));
				extraSpace--;
			} else {
				sb.append(words[beginIndex++]+" ".repeat(spacePerWord));
			}
		}
		sb.append(words[beginIndex]);
		result.add(sb.toString()); 
	}
}