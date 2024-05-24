class KthSymbolInGrammar {
	public static void main(String args[]) {
		int n = 9;
		int k = 15;

		// System.out.println(1 << n);
		// System.out.println(Math.pow(2,n));

		System.out.println(kthGrammar(n, k));
	}

	public static int kthGrammar(int n, int k) {
		int[] last = new int[(int) Math.pow(2, n)];
		for(int i=1; i<n; i++) {
			for(int j=(int) Math.pow(2, i)-1; j>=0; j--) {
				last[2*j] = last[j];
				last[2*j+1] = 1 - last[j];
			}
		}
		return last[k-1];
	}

	// slow. not efficient.
	public static int kthGrammar2(int n, int k) {
        String grammar = "0";
        StringBuilder sb;
        for(int i=2; i<=n; i++) {
            sb=new StringBuilder();
            for(int j=0; j<grammar.length(); j++) {
                sb.append(grammar.charAt(j)=='0' ? "01" : "10");
            }
            grammar = sb.toString();
        }
        return grammar.charAt(k-1) - '0';
    }


}