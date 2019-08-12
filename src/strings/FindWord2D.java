package strings;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Created by JuanCabral on 4/21/19.
 */
public class FindWord2D {

  public boolean exist(char[][] board, String word) {
    return true;
  }

  class Point {
    char c;
    int x;
    int y;
    int index;
    List<Point> neighboors;

    public Point (char c, int x, int y, int index){
      this.c = c;
      this.x = x;
      this.y = y;
      this.index = index;
    }
    public int hashCode(){
      return new StringBuilder("x").append(x).append("y").append(y).toString()
        .hashCode();
    }

  }

  public boolean analyze(char[][] board, char c, int x, int y, String word){
    Set<Point> seen = new HashSet<>();
    Stack<Point> pointStack = new Stack<>();
    Point origin = new Point(c, x,y, 0);
    pointStack.add(origin);
    seen.add(origin);

    while(!pointStack.isEmpty()){
      Point current = pointStack.peek();

      if (current.index == word.length()) return true;



    }
    return true;
  }

  public static void main(String []args){
    System.out.println(new FindWord2D().countBattleships(new char[][]{{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}}));
  }


  public int countBattleships(char[][] board) {
    int count = 0;
    for(int i=0; i<board.length; i++){
      for(int j=0; j<board[i].length; j++){
        count = isThereABattleShipAndRemoveIt(board, i,j)
          ? count + 1 : count;
      }
    }
    return count;
  }

  public boolean isThereABattleShipAndRemoveIt(char [][]board, int x, int y){
    boolean isThereABattleShip = false;
    if(board[x][y] == 'X') {
      isThereABattleShip = true;
      int hor = countHorizontal(x,y,board);
      int ver = countVertical(x,y,board);
      if(hor>ver){
        removeHorizontal(x,y,board);
      } else{
        removeVertical(x,y,board);
      }
    }
    return isThereABattleShip;
  }

  public int countHorizontal(int i, int j, char [][]board){
    int count = 0;
    if(i < board.length && board[i][j] == 'X'){
      count++;
      i = i+1;
    }
    return count;
  }

  public int countVertical(int i, int j, char [][]board){
    int count = 0;
    if(j < board[0].length && board[i][j] == 'X'){
      j = j+1;
      count++;
    }
    return count;
  }

  public void removeHorizontal(int i, int j, char [][]board){
    if(i < board.length && board[i][j] == 'X'){
      board[i][j] = '.';
      i = i+1;
    }
  }

  public void removeVertical(int i, int j, char [][]board){
    if(j < board[0].length && board[i][j] == 'X'){
      board[i][j] = '.';
      j = j+1;
    }
  }

}
