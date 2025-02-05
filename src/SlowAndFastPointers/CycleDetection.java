public class CycleDetection {
  public static void main (String args[]) {
    LinkedList list = new LinkedList();
    int[] vals = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
    for(int val: vals) {
      list.add(val);
    }

    ListNode a = list.head;
    ListNode b = list.head;
    while(a.val!=3) {
      a=a.next;
    }
    while(b.val!=22) {
      b=b.next;
    }
    b.next=a;

    System.out.println(detectCycle(list.head));
  }

  public static boolean detectCycle(ListNode head) {
    if(head==null) return true;
    ListNode slow = head;
    ListNode fast = head;
    
    while(fast!=null && fast.next!=null) {
      slow=slow.next;
      fast=fast.next.next;
      if(slow==fast) return true;
    }
    
    return false;
  }
}

class LinkedList {
  ListNode head;
  public LinkedList() {
    this.head=null;
  }

  public void add(int val) {
    if(head==null) {
      head=new ListNode(val);
      return;
    }
    ListNode curr = head;
    while(curr.next!=null) {
      curr=curr.next;
    }
    curr.next=new ListNode(val);

  }
}

class ListNode {
  int val;
  ListNode next;

  public ListNode(int val) {
    this.val = val;
    this.next=null;
  }
}