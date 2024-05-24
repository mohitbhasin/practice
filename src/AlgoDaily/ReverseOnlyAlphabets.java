class ReverseOnlyAlphabets {
	public static void main(String[] args) {
		char[] arr = {'b','!','f','d','c','e','a','2'};
		reverse(arr);
		for(char c:arr) {
			System.out.print(c);
		}

		System.out.println();
		System.out.println(reverseOnlyLetters("a!fdcea2"));
	}


	public static void reverse(char[] arr) {
		int start=0;
		int end=arr.length-1;
		char a = 'a';
		char z = 'z';
		while(start<end) {
			if(arr[start]<a || arr[start]>z) {
				start++;
				continue;
			}
			if(arr[end]<a || arr[end]>z) {
				end--;
				continue;
			}

			char c = arr[start];
			arr[start++] = arr[end];
			arr[end--] = c;
		}
	}

	public static String reverseOnlyLetters(String s) {
		int i = 0 , j = s.length() - 1 ;
		char[] ch = s.toCharArray();
	    while(i < j) {
	        if(!Character.isLetter(ch[i])) i++;
	        else if(!Character.isLetter(ch[j])) j--;
	        else{
		        char temp = ch[i];
		        ch[i] =ch[j];
		        ch[j] = temp;           
		        i++;
		        j--;
	        }
	    }   
	    return new String(ch);
	}

}

