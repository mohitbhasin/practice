class SortedMerge {
  public static void main(String args[]) {
    int[] A= new int[8];
    A[0] = 1;
    A[1] = 5;
    A[2] = 9;
    A[3] = 10;

    int[] B = new int[] {0, 2, 4, 15};

    merge(A, B);

    for(int num : A) {
      System.out.print(num + "\t");
    }
  }

  public static void merge(int A[], int B[]) {
    int a=0;
    while(A[a]>0) {
      a++;
    }
    a--;

    int b=B.length-1;
    int index=A.length-1;

    while(a>=0 && b>=0) {
      if(B[b]>A[a]) {
        A[index--] = B[b--];
      } else {
        A[index--] = A[a--];
      }
    }

    while(b>=0) {
      A[index--] = B[b--];
    }
  }
}