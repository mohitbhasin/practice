class MyCircularQueue {
    int[] data;
    int head;
    int tail;
    int count;

    public MyCircularQueue(int k) {
        this.data = new int[k];
        this.head=-1;
        this.tail=-1;
        count=0;
    }
    
    public boolean enQueue(int value) {
        if(isEmpty()) {
            ++head;
            if(head==data.length) {
                head=0;
            }
        }
        if(isEmpty()) {
            if(tail==data.length-1) {
                tail=-1;
            }
            data[++tail] = value;
            count++;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if(!isEmpty()) {
            head++;
            if(head==data.length) {
                head=0;
            }
            count--;
            if(isEmpty()) {
                tail=head;
            }
            return true;
        }
        return false;
    }
    
    public int Front() {
        if(isEmpty()) {
            return -1;
        }
        return data[head];
    }
    
    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        return data[tail];
    }
    public boolean isEmpty() {
        return count==0;
    }
    
    public boolean isFull() {
        return count==data.length;
    }
}