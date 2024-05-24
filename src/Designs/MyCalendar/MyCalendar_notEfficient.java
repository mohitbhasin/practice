import java.util.*;

// sequential - not using binay search
class MyCalendar_notEfficient {
    public static void main(String args[]) {
        MyCalendar_notEfficient mycal = new MyCalendar_notEfficient();
        // System.out.println(mycal.book(10,20));
        // System.out.println(mycal.book(15,25));
        // System.out.println(mycal.book(20,30));
        System.out.println(mycal.book(20,29));
        System.out.println(mycal.book(13,22));
        System.out.println(mycal.book(44,50));
        System.out.println(mycal.book(1,7));
        System.out.println(mycal.book(2,10));
        System.out.println(mycal.book(14,20));
        System.out.println(mycal.book(19,25));
        System.out.println(mycal.book(36,42));
        System.out.println(mycal.book(45,50));
        System.out.println(mycal.book(47,50));
        System.out.println(mycal.book(39,45));
        System.out.println(mycal.book(44,50));
        System.out.println(mycal.book(16,25));
        System.out.println(mycal.book(45,50));
        System.out.println(mycal.book(45,50));
        System.out.println(mycal.book(12,20));
        System.out.println(mycal.book(21,29));
        System.out.println(mycal.book(11,20));
        System.out.println(mycal.book(12,17));
        System.out.println(mycal.book(34,40));
        System.out.println(mycal.book(10,18));
        System.out.println(mycal.book(38,44));
        System.out.println(mycal.book(23,32));
        System.out.println(mycal.book(38,44));
        System.out.println(mycal.book(15,20));
        System.out.println(mycal.book(27,33));
        System.out.println(mycal.book(34,42));
        System.out.println(mycal.book(44,50));
        System.out.println(mycal.book(35,40));
        System.out.println(mycal.book(24,31));


    }

    List<int[]> bookedList;
    public MyCalendar_notEfficient() {
        bookedList = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        int pos = 0;
        for(int i=0; i<bookedList.size(); i++) {
            int[] curr = bookedList.get(i);
            if(isOverlapping(curr, start, end)) {
                return false;
            }
            if(end<=curr[0]) {
                break;
            }
            pos++;
        }
        bookedList.add(pos, new int[]{start, end});
        return true;
    }

    public boolean isOverlapping(int[] a, int start, int end) {
        return Math.min(a[1], end)>Math.max(a[0], start);
    }
}