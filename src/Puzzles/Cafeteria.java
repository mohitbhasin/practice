import java.util.*;

// Time limit exceeding for 2 test cases
class Cafeteria {
  public static void main(String args[]) {
      // long N = 1000000000000000l;
      // long K = 1;
      // int M = 2;
      // long[] S = {2, 6};
      long N = 10;
      long K = 1;
      int M = 0;
      long[] S = {2, 6};
      // long N = 15;
      // long K = 2;
      // int M = 3;
      // long[] S = {11, 6, 14};
      // long N = 15;
      // long K = 3;
      // int M = 0;
      // long[] S = {2, 8};
      System.out.println(getMaxAdditionalDinersCount(N,K,M,S));
  }

  public static long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
    long result = 0;
    Arrays.sort(S);
    long left = -K;
    long right = 0;
    int i =0;
    while(i<=S.length) {
      if(i<S.length) {
        right = S[i]; 
      } else {
        result+= (N - right)/(K+1);
        return result;
        // right = N;
        // right+=K+1;
      }
      while(left+K+1<=right-K-1) {
        System.out.println("Pos: "+(left+K+1));
        left+=K+1;
        result++;
      }
      left=right;
      i++;
    }
    return result;
  }
}