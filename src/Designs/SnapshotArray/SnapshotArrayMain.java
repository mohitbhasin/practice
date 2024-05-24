import java.io.*;

// TODO
class SnapshotArrayMain {
	public static void main(String args[]) {
		String callString = "";
		String paramString = "";
		try(BufferedReader br = new BufferedReader(new FileReader("testCase.txt"))) {
			callString = br.readLine();
			paramString = br.readLine();
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		paramString = paramString.substring(0, paramString.length()-2);
		callString = callString.substring(0, callString.length()-1);
		String[] calls = callString.split(",");
		String[] params = paramString.split("\\],\\[", -1);

		String size = params[0].substring(2);

		SnapshotArray snapshotArr = new SnapshotArray(Integer.valueOf(size));

		for(int i=1; i<calls.length; i++) {
			String call = calls[i];
			call = call.substring(1, call.length()-1);
			int a=0;
			int b=0;
			if(params[i].length()!=0) {
				String[] param = params[i].split(",");
				a = Integer.valueOf(param[0]);
				b = Integer.valueOf(param[1]);
			}
			switch(call) {
				case "set" : {
					snapshotArr.set(a, b);
					break;
				}
				case "get" : {
					System.out.println(snapshotArr.get(a, b));
					break;
				}
				case "snap" : {
					System.out.println("snap_id= "+snapshotArr.snap());
					break;
				}
			}
		}
	}
}