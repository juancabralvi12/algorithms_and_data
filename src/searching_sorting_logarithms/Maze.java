package searching_sorting_logarithms;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

class Maze {

  class Point {
    int x;
    int y;
    Point parent;

    public Point(int x, int y, Point parent){
      this.x = x;
      this.y = y;
      this.parent = parent;
    }

    List<Point> getAdj(int [][] m, Set<Point> seen){
       List<Point> adj = new ArrayList<>();
       Point dx = new Point(x-1,y, this);
       if (x-1>=0 && m[x-1][y] == 1 && !seen.contains(dx)) {
          adj.add(dx);
          seen.add(dx);
       }
       Point dy = new Point(x, y-1, this);
       if(y-1>=0 && m[x][y-1] == 1 && !seen.contains(dy)) {
            adj.add(dy);
            seen.add(dy);
       }
       Point dxp = new Point(x+1, y, this);
       if(x+1 < m.length -1 && m[x+1][y] == 1&& !seen.contains(dxp)) {
         seen.add(dxp);
         adj.add(dxp); 
       }
       Point dyp = new Point (x, y+1, this);
       if(y+1 < m[x].length -1 && m[x][y+1] == 1 && !seen.contains(dyp)){
          seen.add(dyp);
          adj.add(dyp);
       }
       return adj;
    }


   boolean isTarget(int [][]m){
      return m[x][y] == 9 ? true : false;
   }    


 } //Point

 Point findRoot(int [][]m){
   for (int i=0; i<m.length; i++){
     for(int j=0; j<m[i].length; j++){
       if(m[i][j] == 1) return new Point(i, j, null);
     }
   }
  return null;
 }

 public void print(Queue<Point> q){
   StringBuilder sb = new StringBuilder();
   for (Point p:q) sb.append(p.x).append(" ").append(p.y).append(" ");
   System.out.println(sb.toString());
 }
 public int findShortestPath(int [][]m){
    Queue<Point> q = new LinkedList<>();
    Set<Point> seen = new HashSet<>();
    int shortest = 0;
    
    Point root = findRoot(m);
    if (root == null) return -1;

    q.add(root);
    seen.add(root);

    while(!q.isEmpty()){
       print(q);
       Point p = q.poll();
       shortest++;
       
       for (Point p1 : p.getAdj(m, seen)){
          q.add(p1);
       }
    }

    return -1;
 }
 
 public static void main(String []args){
     Maze maze = new Maze();   
     int [][]matrix = new int[][]{{1,1,1}, {1,0,1}, {1,9,1}};
     System.out.println(maze.findShortestPath(matrix));
 }

}
