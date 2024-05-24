import java.util.*;

class TextAlignment {
	public static void main(String args[]) {
		leftAlign("This text should be left aligned", 10);
	}

	public static void leftAlign(String s, int width) {
		int currSize = 0;
        int currLineWords = 0;
        String[] words = s.split(" ");
        StringBuilder currLine = new StringBuilder();

        for(int i=0; i<words.length; i++) {
            String word = words[i];
            currLineWords++;
            currSize=currLine.length()+word.length()+1;
            if(currSize==width) {
                currLine.append(word);
            }
            else if(currSize<width) {
                currLine.append(word).append(" ");
            } else {
                System.out.println(currLine.toString());
                currLineWords=1;
                currSize=word.length();
                currLine=new StringBuilder();
                currLine.append(word).append(" ");
            }
        }
        System.out.println(currLine.toString());
    }
}