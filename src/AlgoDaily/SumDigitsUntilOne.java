class SumDigitsUntilOne {
	public static void main(String args[]) {
		System.out.println(solution(439230));
		System.out.println(solution2(439230));
	}

	public static int solution(int num) {    
		if(num<10) {
            return num;
        }

        int sum=0;

        while(num>0 || sum>9) {
            if(num==0) {
                num=sum;
                sum=0;
            }
            sum+=num%10;
            num/=10;
        }
        return sum;
    }

    public static int solution2(int num) {
    	if(num==0) {
    		return 0;
    	}

    	return num%9==0 ? 9 : (num % 9);
    }
}