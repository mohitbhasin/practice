import java.util.*;

class MyCalendar {
    List<int[]> bookedList;
    public MyCalendar() {
        bookedList = new ArrayList<>();
    }

    public static void main(String args[]) {
        MyCalendar myCal = new MyCalendar();
        System.out.println(myCal.book(20,29));
        System.out.println(myCal.book(13,22));
        System.out.println(myCal.book(44,50));
        System.out.println(myCal.book(1,7));
        System.out.println(myCal.book(2,10));
        System.out.println(myCal.book(14,20));
        System.out.println(myCal.book(19,25));
        System.out.println(myCal.book(36,42));
        System.out.println(myCal.book(45,50));
        System.out.println(myCal.book(47,50));
        System.out.println(myCal.book(39,45));
        System.out.println(myCal.book(44,50));
        System.out.println(myCal.book(16,25));
        System.out.println(myCal.book(45,50));
        System.out.println(myCal.book(45,50));
        System.out.println(myCal.book(12,20));
        System.out.println(myCal.book(21,29));
        System.out.println(myCal.book(11,20));
        System.out.println(myCal.book(12,17));
        System.out.println(myCal.book(34,40));
        System.out.println(myCal.book(10,18));
        System.out.println(myCal.book(38,44));
        System.out.println(myCal.book(23,32));
        System.out.println(myCal.book(38,44));
        System.out.println(myCal.book(15,20));
        System.out.println(myCal.book(27,33));
        System.out.println(myCal.book(34,42));
        System.out.println(myCal.book(44,50));
        System.out.println(myCal.book(35,40));
        System.out.println(myCal.book(24,31));

    }

    
    public boolean book(int start, int end) {
        System.out.print(start+","+end+"==");
        int pos = searchPos(start, end);
        if(pos==-1) {
            return false;
        } 
        bookedList.add(pos, new int[]{start, end});
        for(int[] curr: bookedList) {
            System.out.print("("+curr[0]+","+curr[1]+")"+"->");
        }
        return true;
    }

    public int searchPos(int start, int end) {
        int left = 0;
        int right = bookedList.size()-1;

        while(left<=right) {
            int mid = (left+right) / 2;
            int[] curr = bookedList.get(mid);
            if(isOverlapping(curr, start, end)) {
                return -1;
            } else if(curr[0]>=end) {
                right=mid-1;
            } else {
                left=mid+1;
            }
        }
        return left;
    }

    public boolean isOverlapping(int[] a, int start, int end) {
        return Math.min(a[1], end)>Math.max(a[0], start);
    }
}