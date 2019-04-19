package searching_sorting_logarithms;


public class BinarySearch2DMatrix {


   class Tuple {
     int x;
     int y;
   }

   public Tuple computeCoordinates(int n, int row, int col){
      Tuple t = new Tuple();
      t.x = n / col;
      t.y = n - (t.x*col);
      return t;
   }

   public boolean searchMatrix(int[][] matrix, int target) {
     int col = matrix[0].length;
     int row = matrix.length;
     int l = 0;
     int r = (row*col)-1;
     int m = Math.round((l+r)/2f);
    
     //check lower bound
     Tuple crds = computeCoordinates(0, row, col);
     if(matrix[crds.x][crds.y]== target) return true;
     
    //check higher bound
    crds = computeCoordinates(r, row, col);
    if(matrix[crds.x][crds.y] == target) return true;

     while(l < (r-1)){
      crds = computeCoordinates(m, row, col);
      if (target == matrix[crds.x][crds.y]){
         return true;
      } else if( target < matrix[crds.x][crds.y]){
        r=m;
     } else {
        l=m;
     }
     m = Math.round((l+r)/2f);
    }
     return false;
    }


   public static void main(String []args){

     BinarySearch2DMatrix bs = new BinarySearch2DMatrix();
     int [][] matrix = new int[][]{{1,3,4,7}, {10, 11, 16, 20}, {23,30,34,50}};
     System.out.println(bs.searchMatrix(matrix, 2)); 
System.out.println(bs.searchMatrix(matrix, 1));
System.out.println(bs.searchMatrix(matrix, 50));
System.out.println(bs.searchMatrix(matrix, 16));
   }

}
