
// Incorrect. PQ Map not required
class PrintInOrder {
    PriorityQueue<Runnable> pq;
    Map<Runnable, Integer> priorityMap;
    public Foo() {
        pq = new PriorityQueue<>(new Comparator<Runnable>() {
            public int compare(Runnable a, Runnable b) {
                return priorityMap.get(a) - priorityMap.get(b);
            }
        });
        priorityMap = new HashMap<>();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        priorityMap.put(printFirst, 1);
        enqueue(printFirst);
        // printFirst.run() outputs "first". Do not change or remove this line.
        // printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        priorityMap.put(printSecond, 2);
        enqueue(printSecond);
        // printSecond.run() outputs "second". Do not change or remove this line.
        // printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        priorityMap.put(printThird, 3);
        enqueue(printThird);
        // printThird.run() outputs "third". Do not change or remove this line.
        // printThird.run();
    }
    
    public void enqueue(Runnable task) {
        pq.offer(task);
        if(pq.size()==3) {
            while(!pq.isEmpty()) {
                pq.poll().run();
            }
        }
    }
}

class OnlineSolution {

    boolean firstPrinted;
    boolean secondPrinted;
    
    public Foo() {
        firstPrinted = false;
        secondPrinted = false;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstPrinted = true;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        while (!firstPrinted) {
            wait();
        }
        
        printSecond.run();
        secondPrinted = true;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        while (!firstPrinted || !secondPrinted) {
           wait();
        }
    
        printThird.run();
    }
}