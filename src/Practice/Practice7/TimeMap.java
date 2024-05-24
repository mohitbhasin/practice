import java.util.*;

class TimeMap {
    // incorrect answer
    public static void main(String args[]) {
        TimeMap timeMap = new TimeMap();
        // timeMap.set("foo","bar",1);

        // System.out.println(timeMap.get("foo",1));
        // System.out.println(timeMap.get("foo",3));

        // timeMap.set("foo","bar2",4);

        // System.out.println(timeMap.get("foo",4));
        // System.out.println(timeMap.get("foo",5));

        timeMap.set("love", "high", 10);  // store the key "foo" and value "bar" along with timestamp = 1.
        timeMap.set("love", "low", 20); // store the key "foo" and value "bar2" along with timestamp = 4.
        
        System.out.println(timeMap.get("love", 5));         // return "bar"
        System.out.println(timeMap.get("love", 10));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        System.out.println(timeMap.get("love", 15));         // return "bar2"
        System.out.println(timeMap.get("love", 20));         // return "bar2"
        System.out.println(timeMap.get("love", 25));

    }

    Map<String, List<String[]>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        
        List<String[]> list = map.get(key);
        String[] timeValArr = new String[2];
        timeValArr[0]=""+timestamp;
        timeValArr[1]=value;
        
        list.add(timeValArr);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        if(timestamp<Integer.valueOf(map.get(key).get(0)[0]));
        
        List<String[]> list = map.get(key);
        
        int left = 0;
        int right = list.size();
        
        while(left<right) {
            int mid = (left+right)/2;
            int time = Integer.valueOf(list.get(mid)[0]);
            
            if(time<=timestamp) {
                left=mid+1;
            } else {
                right=mid;
            }
        }

        if(right==0) {
            return "";
        }

        return list.get(right - 1)[1];
    }
}