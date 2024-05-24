import java.util.*;

class LengthOfLastWord {
	public static void main(String args[]) {
		List<String> list = new ArrayList<>();
		list.add("Hello World");
		list.add("   fly me   to   the moon  ");
		list.add("luffy is still joyboy");

		for(String s: list) {
			System.out.println(lengthOfLastWord(s));
		}
	}

	public static int lengthOfLastWord(String s) {
        int i = s.length()-1;
        while(i>=0 && s.charAt(i)==' ') {
            i--;
        }
        int count=0;
        if(i==-1) return 0;
        while(i>=0 && s.charAt(i--)!=' ') {
            count++;
        }
        return count;
    }
}