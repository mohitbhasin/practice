import java.util.*;

class ReverseWords {
	public static void main(String args[]) {
		List<String> list = new ArrayList<>();
		list.add("the sky is blue");
		list.add("  hello world  ");
		list.add("a good   example");

		for(String s: list) {
			System.out.println(reverseWords(s));
		}
	}

	public static String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i=split.length-1; i>=0; i--) {
            if(!split[i].equals(""))
            sb.append(split[i]+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}