import java.util.*;

class MinimumAreaRectangle {
    public static void main(String[] args) {
        int[][] points = {{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}};
        System.out.println(minAreaRect(points));
    }

    public static int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int area = Integer.MAX_VALUE;

        for(int[] point: points) {
            if(map.containsKey(point[0]) && map.containsKey(point[1])) {
                for(int b: map.get(point[0])) {
                    if(b!=point[0] && map.containsKey(b)) {
                        for(int c: map.get(b)) {
                            if(c==point[1] && ) {
                                int tempArea = Math.abs(point[1] - b) * Math.abs(point[0] - c);
                                area = Math.min(area, tempArea);
                            }
                        }
                    }
                }
            }
            if(!map.containsKey(point[0])) {
                map.put(point[0], new HashSet<>());
            }
            map.get(point[0]).add(point[1]);
        }
        return area;
    }
}