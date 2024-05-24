import java.util.*;

class PerfectSquares {
	public static void main(String args[]) {
		// System.out.println(numSquares(7168));
		System.out.println(numSquares_set(7168));
		// System.out.println(numSquares_set(13));
	}

	public static int numSquares_set(int n) {
		List<Integer> nums = new ArrayList<>();

        for(int i=1; i*i<=n; i++) {
            nums.add(0, i*i);
        }

		Set<Integer> que = new HashSet<>();
		que.add(n);
		int depth=0;

		while(!que.isEmpty()) {
			Set<Integer> newQue = new HashSet<>();
			for(int remainder: que) {
				if(remainder==0) return depth;
				for(int num: nums) {
					int temp = remainder - num;
					if(temp>=0) {
						newQue.add(temp);
					}
				}
			}
			que=newQue;
			depth++;
		}
		return -1;
	}

	//(typical BFS) this method is slow for large numbers
	public static int numSquares(int n) {
        List<Integer> nums = new ArrayList<>();

        for(int i=1; i*i<=n; i++) {
            nums.add(0, i*i);
        }

        System.out.println(nums);

        Queue<Integer> que = new LinkedList<>();
        Set<Integer> memo = new HashSet<>();

        que.offer(n);
        que.offer(null);
        int depth=0;
        while(!que.isEmpty()) {
            Integer curr = que.poll();
        	System.out.println(curr);
            if(curr==null) {
                depth++;
                if(que.peek()!=null) {
                    que.offer(null);
                }
            }
            else if(curr==0) {
                return depth;
            }
            else if(curr>0) {
                for(int num: nums) {
                    if(curr-num>=0) que.offer(curr-num);
                }
            }
        }
        return -1;
    }
}