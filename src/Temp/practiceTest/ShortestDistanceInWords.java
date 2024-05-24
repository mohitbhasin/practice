class ShortestDistanceInWords {
	public static void main(String args[]) {
		String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "coding";
		String word2 = "practice";
		System.out.println(shortestDistance(wordsDict, word1, word2));
	}

	 public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        int firstIndex=-1;
		int secondIndex=-1;
        int distance = Integer.MAX_VALUE;
        for(int i=0; i<wordsDict.length; i++) {
			String curr=wordsDict[i];
			if(curr.equals(word1)) {
				firstIndex=i;
			}
			if(curr.equals(word2)) {
				secondIndex=i;
			}
			if(firstIndex!=-1&&secondIndex!=-1) {
				distance=Math.min(distance, Math.abs(firstIndex-secondIndex));
			}
        }
        return distance;
    }
}