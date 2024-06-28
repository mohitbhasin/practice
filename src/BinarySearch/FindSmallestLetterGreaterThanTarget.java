class FindSmallestLetterGreaterThanTarget {
	public static void main(String[] args) {
		char[][] lettersArr = {{'x','x','y','y'}, {'c','f','j'}, {'c','f','j'}, {'e','e','g','g'}};
		char[] targets = {'z', 'a', 'c', 'g'};

		for(int i=0; i<lettersArr.length; i++) {
			System.out.println(targets[i]+": "+nextGreatestLetter(lettersArr[i], targets[i]));
			System.out.println(targets[i]+": "+nextGreatestLetter_template_2(lettersArr[i], targets[i]));
		}
	}

	public static char nextGreatestLetter(char[] letters, char target) {
		int left = 0;
		int right = letters.length - 1;

		while(left<=right) {
			int mid = left + (right-left)/2;
			if(letters[mid]<=target) left = mid+1;
			else right = mid-1;
		}
		return left==letters.length ? letters[0] : letters[left];
	}

	// using template 2
	public static char nextGreatestLetter_template_2(char[] letters, char target) {
        int left = 0;
        int right = letters.length-1;
        
        while(left<right) {
            int mid = left + (right-left)/2;
            
            if(letters[mid]<=target) {
                left = mid+1;
            } else {
                right=mid;
            }
        }
        if(letters[left]==target) {
        	if(left==letters.length-1) {
        		return letters[0];
        	} else {
        		return letters[left+1];
        	}
        }
        else if(letters[left]<target) return letters[0];
        else return letters[left];
    }
}