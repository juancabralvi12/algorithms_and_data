package arrays;

public class SudokuChecker {

   public static void main(String []args){
   int[][] A =     {{4,2,9,8,1,3,5,6,7}, 
                    {5,1,6,4,7,2,9,3,8}, 
                    {7,8,3,6,5,9,2,4,1}, 
                    {6,7,2,1,3,4,8,5,9}, 
                    {3,9,5,2,8,6,1,7,4}, 
                    {8,4,1,7,9,5,6,2,3}, 
                    {1,5,8,3,6,7,4,9,2}, 
                    {9,3,4,5,2,8,7,1,6}, 
                    {2,6,7,9,4,1,3,8,5}}; 
     System.out.println(String.format("A is a " + (new SudokuChecker().sudokuChecker(A) ? "valid" : "not valid") + " sudoku"));
   }

  public boolean checkRegion(int[][]A, int startRegionX, int startRegionY, int delta, int []auxiliary){

    for (int i=startRegionX; i< startRegionX + delta; i++) {
        for (int j=startRegionY; j < startRegionY + delta; j++) {
  	    if( check_auxiliary(A[i][j], auxiliary)){
             return true; 
           }
        }
    }

   return false;
  }

   public void clearAuxiliary(int []auxiliary, int size){
     auxiliary = new int[size];
   }

  public void printAuxiliary(int []auxiliary){
  
   for (int value: auxiliary){
     System.out.print(value);
   }
  System.out.println(); 
  }

   public boolean sudokuChecker (int [][]A){
     int[] auxiliary = new int[A.length + 1];

     //check rows 
     for (int i = 0; i<A.length; i++){
	for (int j=0; j<A[0].length; j++){
 	   if (check_auxiliary(A[i][j], auxiliary)){
             System.out.println(String.format("false by checking rows: i:%s j:%s value:%s",i,j, A[i][j]));
 	     return false;
 	   }
	}
        auxiliary = new int[A[0].length + 1];
      } 

     auxiliary = new int[A[0].length + 1] ;
    //check columns
    for (int j=0; j<A[0].length; j++){
     for (int i = 0; i<A.length; i++){
           if(check_auxiliary(A[i][j], auxiliary)){
               System.out.println("false by columns");
                return false;
            }
        }
 auxiliary = new int[A[0].length + 1];
      }

     auxiliary = new int[A[0].length + 1];
 
    int multiplier = (int)Math.sqrt(A.length);

    for (int i=0; i<A.length; i+=multiplier){
       for (int j=0; j<A[0].length; j+=multiplier){
           boolean regionResult = checkRegion(A, i, j, multiplier, auxiliary);
           auxiliary = new int[A[0].length + 1];
          if(regionResult){
           System.out.println("false by region i: " + i + " j: " + j);
           return false;
          }
        }
    }

 return true;
   }

   public static boolean check_auxiliary(int value, int []auxiliary){
       if (auxiliary[value] < 1) {
        auxiliary[value]++;
	return false;
      }  else {
        return true;
      
   }
  }
}



