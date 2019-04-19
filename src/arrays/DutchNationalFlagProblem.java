package arrays;

import java.util.Arrays;

public class DutchNationalFlagProblem {

  public static void main(String []args){


    int [] A = new int[]{0,1,2,0,2,1,1};
    int pivotIndex = 1;
    reorder(A, pivotIndex);
    System.out.println(Arrays.toString(A));

  }



  public static int [] reorder(int []A, int pivotIndex){
    int l =0;
    int r= A.length-1;
    int pivot = A[pivotIndex];
    for (int k=0; k<A.length; k++){
      if (A[k] < pivot ) {
        swap(l++, k, A);
      }
    }

    for (int k=0; k<A.length; k++){
      if (A[k] == pivot ) {
        swap(l++, k, A);
      }
    }


    return A;
  }

  public static void swap(int i, int iL, int []A){
    int temp = A[i];
    A[i] = A[iL];
    A[iL] = temp;
  }


}

