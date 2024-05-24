class MyHashMap {
    List<Bucket> buckets;
    int key_size;
    public MyHashMap() {
        this.key_size = 2069;
        this.buckets = new ArrayList<>();
        for(int i=0; i<key_size; i++) {
            this.buckets.add(new Bucket());
        }
    }
    
    public void put(int key, int value) {
        int index = key%key_size;
        this.buckets.get(index).update(key, value);
    }
    
    public int get(int key) {
        int index = key%key_size;
        return this.buckets.get(index).get(key);
    }
    
    public void remove(int key) {
        int index = key%key_size;
        this.buckets.get(index).remove(key);
    }
}

class Pair<U,V> {
    U key;
    V value;
    
    public Pair(U key, V value) {
        this.key = key;
        this.value=value;
    }
}

class Bucket {
    List<Pair<Integer, Integer>> bucket;
    
    public Bucket() {
        this.bucket = new LinkedList<>();
    }
    
    public Integer get(Integer key) {
        for(Pair<Integer, Integer> pair: bucket) {
            if(key.equals(pair.key)) {
                return pair.value;
            }
        }
        return -1;
    }
    
    public void update(Integer key, Integer value) {
        boolean found = false;
        for(Pair pair: bucket) {
            if(key.equals(pair.key)) {
                found=true;
                pair.value=value;
            }
        }
        if(!found) {
            bucket.add(new Pair(key, value));
        }
    }
    
    public void remove(Integer key) {
        for(Pair pair: bucket) {
            if(key.equals(pair.key)) {
                bucket.remove(pair);
                break;
            }
        }
    }
}