package arrays;

import java.util.*;

public class IncrementArbitraryInteger {


  public static void main(String []args){

    int []A = new int[]{9,9,9,9,9};
    int residual = 1;
    for (int r=A.length-1; r>=0 && residual>0; r--){
      if (A[r]==9){
        A[r] = 0;
        residual = 1;
      } else {
        A[r] +=residual;
        residual = 0;
      }
    }

    if (residual > 0) {
      int []newA = new int[A.length + 1];
      for (int r = A.length - 1; r>0; r--) {
        newA[r] = A[r];
      }
      newA [0] = residual;
      A = newA;
    }

    System.out.println(Arrays.toString(A));

  }



}

