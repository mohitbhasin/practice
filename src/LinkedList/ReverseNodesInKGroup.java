
// TODO - Manually
class ReverseNodesInKGroup {
    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(5);
        head.add(6);

        ListNode result = reverseKGroup_leetcode(head, 2);

        while(result!=null) {
            System.out.print(result.val+" --> ");
            result=result.next;
        }
    }

    // Not clear - leetcode o(1) space solution
    public static ListNode reverseKGroup_leetcode(ListNode head, int k) {
        ListNode curr = head;
        ListNode tail = null;
        ListNode newHead = null;
        
        while(curr != null) {
            int count = 0;
            curr = head;
            
            while(count<k && curr!=null) {
                curr = curr.next;
                count++;
            }
            
            if(count==k) {
                ListNode revHead = reverse(head, k);
                if(newHead==null) {
                    newHead = revHead;
                }
                
                if(tail!=null) {
                    tail.next = revHead;
                }
                
                tail = head;
                head = curr;
            }
        }
        if(tail!=null) {
            tail.next = head;
        }
        
        return newHead == null ? head : newHead;
    }
    
    public static ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        
        while(k>0) {
            ListNode next = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        return prev;
    }



    // not clear
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k==1)
            return head;

        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode pre = fake;
        int i=0;

        ListNode p = head;
        while(p!=null){
            i++;
            if(i%k==0){
                pre = reverse(pre, p.next);
                p = pre.next;
            }else{
                p = p.next; 
            }
        }

        return fake.next; 
    }
    public static ListNode reverse(ListNode pre, ListNode next){
        ListNode last = pre.next;
        ListNode curr = last.next;

        while(curr != next){
            last.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = last.next;
        }

        return last; 
    }
}