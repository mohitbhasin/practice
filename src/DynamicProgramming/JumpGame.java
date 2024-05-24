import java.util.*;
import java.io.*;

class JumpGame {
	public static void main(String args[]) {

		String s = "";
		try(BufferedReader br = new BufferedReader(new FileReader("jumpgame.txt"))) {
			s = br.readLine();
		}
		catch(Exception e) {

		}
		String[] str = s.split(",");
		int[] nums = new int[str.length];
		for(int i=0; i<str.length; i++) nums[i] = Integer.valueOf(str[i]);
		System.out.println(canJump(nums));
	}

	enum Index {
    	GOOD, BAD, UNKNOWN
	}

	static Index[] memo;

    public static boolean canJumpFromPosition(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true : false;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }

        memo[position] = Index.BAD;
        return false;
    }

    public static boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(0, nums);
    }
}