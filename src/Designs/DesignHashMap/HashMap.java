import java.util.*;

class HashMap {
	Bucket[] bucketArr;
	int size;

	public HashMap() {
		this.size = 769;
		this.bucketArr = new Bucket[size];
		for(int i=0; i<bucketArr.length; i++) {
			bucketArr[i] = new Bucket();
		}
	}
    
	public int hash(int key) {
		return key%size;
	}

    public void put(int key, int value) {
        int index = hash(key);
        bucketArr[index].update(key, value);
    }
    
    public int get(int key) {
        int index = hash(key);
        return bucketArr[index].get(key);
    }
    
    public void remove(int key) {
        int index = hash(key);
         bucketArr[index].delete(key);
    }


	class Bucket {
		LinkedList<Integer[]> container = new LinkedList<>();
		public Bucket() {
			this.container = new LinkedList<>();
		}

		public void delete(int key) {
			for(Integer[] pair: container) {
				if(pair[0]==key) {
					container.remove(pair);
					break;
				}
			}
		}

		public void update(int key, int value) {
			boolean found = false;
			for(Integer[] pair: container) {
				if(pair[0]==key) {
					found=true;
					pair[1]=value;
				}
			}
			if(!found) {
				container.addFirst(new Integer[]{key,value});
			}
		}

		public int get(int key) {
			for(Integer[] pair: container) {
				if(pair[0]==key) {
					return pair[1];
				}
			}
			return -1;
		}
	}
}