class MyLinkedList {
	ListNode head;
	public MyLinkedList() {
    }
    
    public int get(int index) {
        if(head==null) {
        	return -1;
        }
        ListNode curr = head;
        while(index>0 && curr!=null) {
        	index--;
        	curr=curr.next;
        }

        if(curr==null) return -1;

        return curr.val;

    }
    
    public void addAtHead(int val) {
        if(head==null) {
        	head = new ListNode(val);
        	return;
        }

        ListNode curr = new ListNode(val);
        curr.next = head;
        head=curr;
    }
    
    public void addAtTail(int val) {
    	if(head==null) {
    		head = new ListNode(val);
    		return;
    	}
    	ListNode curr = head;
    	while(curr.next!=null) {
    		curr=curr.next;
    	}
    	curr.next = new ListNode(val);
    }
    
    public void addAtIndex(int index, int val) {
    	if(index==0) {
    		addAtHead(val);
    		return;
    	}
    	ListNode prev = head;
    	while(index>1 && prev.next!=null) {
    		index--;
    		prev=prev.next;
    	}
    	if(index==1 && prev!=null) {
    		ListNode curr = new ListNode(val);
    		curr.next = prev.next;
    		prev.next = curr;
    	}
    }
    
    public void deleteAtIndex(int index) {
        if(head==null) {
        	return;
        }
        if(index==0 && head!=null) {
        	head=head.next;
        	return;
        }
        if(index==1) {
        	if(head.next!=null) {
        		head.next = head.next.next;
        		return;
        	}
        	return;
        }
        ListNode prev = head;
        while(index>1 && prev.next!=null) {
        	index--;
        	prev=prev.next;
        }
        if(index==1 && prev.next!=null) {
        	prev.next=prev.next.next;
        }
    }

    public void print() {
    	ListNode curr = head;
    	while(curr!=null) {
    		System.out.print(curr.val+" --> ");
    		curr=curr.next;
    	}
    	System.out.println();
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val=val;
	}
}