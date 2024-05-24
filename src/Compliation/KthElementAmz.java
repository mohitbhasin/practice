class KthElementAmz {
    public static void main(String args[]) {
        int a1[] = {1,3,6,7,8};
        int a2[] = {2,4,9,8,10};
        System.out.println(findKthElement(a1, a2, 2));
    }
    public static int findKthElement(int[] a1, int[] a2, int k) {
        int indexA1 = 0;
        int indexA2 = 0;
        
        for(int i=0; i<k-1; i++) {
            if(indexA1<a1.length && indexA2<a2.length) {
                if(a1[indexA1]<a2[indexA2]) {
                    indexA1++;
                } else {
                    indexA2++;
                }
            }
            else {
                if(indexA1<a1.length) {
                    indexA1++;
                }
                if(indexA2<a2.length) {
                    indexA2++;
                }
            }
        }
        return Math.min(a1[indexA1], a2[indexA2]);    
    }
}