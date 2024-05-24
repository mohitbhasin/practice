import java.util.*;
import java.io.*;

class HashSetMain {
	public static void main(String args[]) {
		String[] functions = null;
		String[] values = null;
		try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
			functions = br.readLine().split(",");
			values = br.readLine().split(",");;
		}
		catch(Exception e) {

		}
		HashSet set = new HashSet();

		for(int i=1; i<functions.length; i++) {
			String call = functions[i];
			call = call.substring(1, call.length()-1);
			String argStr = values[i];
			int arg = Integer.parseInt(argStr.substring(1, argStr.indexOf("]")));
			switch (call) {
				case "add" -> {
					set.add(arg);
					break;
				}
				case "remove" -> {
					set.remove(arg);
					break;
				}
				case "contains" -> {
					System.out.println(set.contains(arg));
					break;
				}
			}
		}
		// System.out.println(list);
	}
}