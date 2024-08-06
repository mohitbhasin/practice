import java.util.*;

class LFUCache {
    Map<Integer, Pair> cache;
    Map<Integer, LinkedHashSet<Integer>> frequencies;
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.cache = new HashMap<>();
        this.frequencies = new HashMap<>();
        this.capacity=capacity;
        this.minFreq=0;
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Pair pair = cache.get(key);
        frequencies.get(pair.frequency).remove(key);
        if(frequencies.get(pair.frequency).isEmpty()) {
            frequencies.remove(pair.frequency);
        }
        if(minFreq==pair.frequency && frequencies.get(pair.frequency)==null) {
            minFreq++;
        }
        pair.frequency++;
        frequencies.putIfAbsent(pair.frequency, new LinkedHashSet<>());
        frequencies.get(pair.frequency).add(key);
        return pair.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            cache.get(key).value=value;
            get(key);
        } else {
            if(cache.size()>=capacity) {
                int minKey = frequencies.get(minFreq).iterator().next();
                frequencies.get(minFreq).remove(minKey);
                cache.remove(minKey);
            }
            cache.put(key, new Pair(value, 1));
            frequencies.putIfAbsent(1, new LinkedHashSet<>());
            frequencies.get(1).add(key);
            minFreq=1;
        }
    }

    class Pair {
        int value;
        int frequency;
        public Pair(int value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }
    }
}