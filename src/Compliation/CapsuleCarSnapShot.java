import java.util.*;

class CapsuleCarSnapShot {
	public static void main(String args[]) {
		for(String s: snapShots("R...L..", 1)) {
			System.out.println(s);
		}
	}

	public static ArrayList<String> snapShots(String initialState, int carSpeed) {
		ArrayList<String> result = new ArrayList<String>();
		int lIndex = initialState.indexOf('L');
		int rIndex = initialState.indexOf('R');
		StringBuilder sb = new StringBuilder(initialState);
		if(lIndex!=-1) sb.replace(lIndex, lIndex+1, ".");
		if(rIndex!=-1) sb.replace(rIndex, rIndex+1, ".");
		
		String temp=sb.toString();
		while(rIndex<initialState.length() || lIndex>=0) {
			sb = new StringBuilder(temp);
			if(rIndex<initialState.length()) {
				sb.replace(rIndex, rIndex+1, "x");
				rIndex=rIndex+carSpeed;
			}
			if(lIndex>=0) {
				sb.replace(lIndex, lIndex+1, "x");
				lIndex=lIndex-carSpeed;
			}
			result.add(sb.toString());
		}

		result.add(temp);
		return result;
	}
}