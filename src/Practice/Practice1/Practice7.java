class Practice7 {
	public static void main(String args[]) {
		// System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
		System.out.println(maxArea2(new int[]{1,8,6,2,5,4,8,3,7}));
	}

	public static int maxArea(int[] height) {
        int maxArea=0;
        for(int i=0; i<height.length-1; i++) {
        	for(int j=i+1; j<height.length; j++) {
        		int minLenOfHeight=Math.min(height[i], height[j]);
        		int currLenght=j-i;
        		int temArea=minLenOfHeight*currLenght;
        		maxArea=Math.max(maxArea, temArea);
        	}
        }
        return maxArea;
    }

    public static int maxArea2(int[] height) {
        int maxArea=0;
        int i=0; int j=height.length-1;
        while(i<j) {
        	maxArea=Math.max(maxArea, ((j-i)*Math.min(height[i], height[j])));
        	if(height[i]<height[j]) i++;
        	else j--;
        }
        return maxArea;
    }

}