import java.io.BufferedReader;
import java.io.FileReader;

class SumFile {
	public static void main(String args[]) {
		System.out.println(sum("numbers.txt"));
	}

	public static int sum(String name) {
		int total=0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(name));

			for(String s=br.readLine(); s!=null; s=br.readLine()) {
				total += Integer.parseInt(s);
			}
			br.close();
		}

		catch(Exception e) {
			e.printStackTrace();
		}
		

		return total;
	}
}