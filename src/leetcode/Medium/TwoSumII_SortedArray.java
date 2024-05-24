class TwoSumII_SortedArray {
    public static void main(String args[]) {
        int[] numbers = {2,7,11,15};
        int[] result = twoSum(numbers, 9);
        System.out.println(result[0]+", "+result[1]);
    }


    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for(int i=0; i<numbers.length-1; i++) {
            int k = binarySearch(numbers, i+1, target-numbers[i]);
            if(k!=-1){
                result[0]=i+1;
                result[1]=k+1;
                break;
            }
        }
        return result;        
    }
    
    private static int binarySearch(int[] numbers, int index, int val) {
        int left = index;
        int right = numbers.length-1;
        while(left<=right) {
            int mid = (left+right)/2;
            if(numbers[mid]==val) {
                return mid;
            } else if(numbers[mid]>val) {
                right=mid-1;
            } else {
                left=mid+1;
            }
        }
        return -1;
    }
}