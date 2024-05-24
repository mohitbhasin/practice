class SparseSearch {
	public static void main(String args[]) {
		// System.out.println(seach(new String[] {"at", "", "", "", "ball", "", "", "cat", "", "", "dad", "", ""}, "dad"));
		System.out.println(recur(new String[] {"at", "", "", "", "ball", "", "", "cat", "", "", "dad", "", ""}, "at", 0, 13));
		// System.out.println(recur(new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m"}, "c", 0, 13));
	}

	public static int seach(String[] strings, String word) {
		int pre=0;
		int next=0;

		while(next<strings.length) {
			if(strings[next]!="") {
				strings[pre++]=strings[next++];
			} else {
				next++;
			}
		}
		return searchString(strings, word, 0, pre);
	}

	public static int searchString(String[] strings, String word, int low, int high) {
		int mid=0;
		while(low<=high) {
			mid=(low+high)/2;
			if(strings[mid].compareTo(word)==0) {
				return mid;
			} else if(strings[mid].compareTo(word) > 0) {
				high=mid-1;
			} else {
				low=mid+1;
			}
		}
		return -1;
	}

	public static int recur(String[] words, String word, int low, int high) {
		if(low>high) {
			return -1;
		}
		int mid=(low+high)/2;

		if(words[mid].isEmpty()) {
			int left=mid-1;
			int right=mid+1;
			while(true) {
				if(left<low && right>high) {
					return -1;
				}

				if(!words[left].isEmpty()) {
				 	mid=left;
				 	break;
				}

				if(!words[right].isEmpty()) {
				 	mid=right;
				 	break;
				}

				left--;
				right++;
			}
		}

		if(word.compareTo(words[mid])>0) {
			return recur(words, word, mid+1, high);
		}

		if(word.compareTo(words[mid])<0) {
			return recur(words, word, low, mid-1);	
		}

		return mid;
	}
}
















