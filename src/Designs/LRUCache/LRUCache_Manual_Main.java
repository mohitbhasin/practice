class LRUCache_Manual_Main {
	public static void main(String args[]) {

		LRUCache_Manual lru = new LRUCache_Manual(2);
		lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1));
        lru.put(3, 3);
        System.out.println(lru.get(2));
        lru.put(4, 4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));

		// LRUCache_Manual cache = new LRUCache_Manual(2);
  //       cache.put(1, 1);
  //       cache.put(2, 2);
  //       System.out.println(cache.get(1));
  //       cache.put(3, 3);
  //       System.out.println(cache.get(2));
  //       cache.put(4, 4);
  //       System.out.println(cache.get(1));
  //       System.out.println(cache.get(3));
  //       System.out.println(cache.get(4));

		// LRUCache_Manual cache = new LRUCache_Manual(2);        
		// cache.put(1, 0);
		// cache.put(2, 2);
		// System.out.println(cache.get(1));
		// cache.put(3, 3);
		// System.out.println(cache.get(2));
		// cache.put(4, 4);
		// System.out.println(cache.get(1));
		// System.out.println(cache.get(3));
  //       System.out.println(cache.get(4));


		// ["LRUCache","put","put","put","put","get","get"]
		// [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]

		// LRUCache_Manual cache = new LRUCache_Manual(2);
		// cache.put(2, 1);
		// System.out.println(cache.map.keySet());
		// cache.put(1, 1);
		// System.out.println(cache.map.keySet());
		// cache.put(2, 3);
		// System.out.println(cache.map.keySet());
		// cache.put(4, 1);
		// System.out.println(cache.map.keySet());
		// System.out.println(cache.get(1));
  //       System.out.println(cache.get(2));


  //       ["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
		// [[3],		[1,1],[2,2],[3,3],[4,4],[4],[3],	[2],  [1],  [5,5],[1],  [2],  [3],  [4],  [5]]


		// LRUCache_Manual cache = new LRUCache_Manual(3);
		// cache.put(1, 1);
		// cache.put(2, 2);
		// cache.put(3, 3);
		// cache.put(4, 4);
		// System.out.println(cache.get(4));
		// System.out.println(cache.get(3));
		// System.out.println("--->"+cache.tail.prev.key);		
		// System.out.println(cache.get(2));
		// System.out.println("--->"+cache.tail.prev.key);
		// System.out.println(cache.get(1));
		// cache.put(5, 5);
		// System.out.println(cache.map.keySet());
		// System.out.println(cache.get(1));
		// System.out.println(cache.get(2));
		// System.out.println(cache.get(3));
		// System.out.println(cache.get(4));
		// System.out.println(cache.get(5));
		// System.out.println(cache.map.keySet());

    }
}