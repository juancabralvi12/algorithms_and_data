package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {


  public class Q {
    int x;
    int y;

    public Q(int x, int y){
      this.x = x;
      this.y = y;
    }
   }
  public boolean check(int x, int y, List<Q> q){
    for(Q c : q){
       if(x == c.x || y == c.y || (Math.abs(x-c.x) == Math.abs(y-c.y))){
         return true;
       }

    }
   return false;
  } 

  public List<Q> findQs(int level, int row, int col, List<Q> q){
    //we have a solution :) 
    if (level == col) return q;

    for (int i=level, j=0; i<row; j++){
      if (!check(i, j, q)){
       Q qc = new Q(i, j);
       q.add(qc);
       findQs(level + 1, row, col, q);
       if(q.size() == col) {
       return q;
       }

       else { 
         q.remove(q.size() - 1);
       }

      }

   }
   return q;
  }

  public static void main(String []args){
      NQueen nqueen = new NQueen();

      List<Q> qSol = nqueen.findQs(0, 4, 4, new ArrayList<>());
      for(Q q : qSol){
         System.out.println(String.format("q.x : %s; q.y : %s;", q.x, q.y));

     }
  }



}


