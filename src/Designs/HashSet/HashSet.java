import java.util.*;

class HashSet {
	Bucket[] bucketArr;
	int size;

    public HashSet() {
        this.size = 769;
		this.bucketArr = new Bucket[size];
		for(int i=0; i<bucketArr.length; i++) bucketArr[i] = new Bucket();
    }
    
    private int hash(int key) {
		return key%size;
	}
    
    public void add(int key) {
        int index = hash(key);
        bucketArr[index].insert(key);
    }
    
    public void remove(int key) {
        int index = hash(key);
        bucketArr[index].delete(key);
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        return bucketArr[index].exists(key);
    }
    
    class Bucket {
    	LinkedList<Integer> list;
    	public Bucket() {
    		list = new LinkedList<>();
    	}

    	public void insert(Integer key) {
    		int index = list.indexOf(key);
    		if(index==-1) list.addFirst(key);
    	}

    	public boolean exists(Integer key) {
    		return list.indexOf(key)!=-1;
    	}

    	public void delete(Integer key) {
    		list.remove(key);
    	}
    }
}