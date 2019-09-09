/*

from leetcode.com
317. Shortest Distance from All Buildings

You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
Example:

Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

Output: 7

Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
             the point (1,2) is an ideal empty land to build a house, as the total
             travel distance of 3+3+1=7 is minimal. So return 7.
Note:
There will be at least one building. If it is not possible to build such house according to the above rules, return -1.

*/

/*
1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0


(0,0)

(0,1)
(1,0)

(0,4)

(0,3)
(1,4)

(2,2)

(2,1)
(1,2)
(2,3)



k v
(0,1) 1
(1,0)
*/
package bfs;

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

//https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-046j-introduction-to-algorithms-sma-5503-fall-2005/video-lectures/lecture-7-hashing-hash-functions/

public class BestHouseAroundBuildings {

    class Point {

        Queue<Point> q = new LinkedList<>();
        int x;
        int y;
        int distance;
        Point winner;

        int [][] neighbors = new int[][]{
                {0, -1}, // left
                {1, 0},  // down
                {-1, 0}, // up
                {0, 1}}; // right

        Set<Point> seen;


        public List<Point> getNeighbors(int[][] grid, Set<Point> seen) {
            List<Point> n = new ArrayList<>();
            Point p = this;
            for (int[] neighbor : neighbors) {
                int nx = neighbor[0] + p.x;
                int ny = neighbor[1] + p.y;
                if (nx >= 0 && nx < grid.length
                        && ny >= 0 && ny < grid[0].length
                        && grid[nx][ny] == 0
                        && !seen.contains(new Point(nx,ny, distance + 1,seen))) {
                    n.add(new Point(nx, ny, distance + 1, seen));
                    seen.add(new Point(nx,ny, distance + 1, seen));
                }
            }
            return n;
        }

        Point(int x, int y, int distance, Set<Point> seen) {
            this.x = x;
            this.y = y;
            q.add(this);
            this.distance = distance;
            this.seen = seen;
        }

        @Override
        public String toString() {
            return String.format("[x:%s,y:%s]",x,y);
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 71 * hash + this.x;
            hash = 71 * hash + this.y;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true;

            if(! (obj instanceof Point))
                return false;

            Point other = (Point) obj;
            return other.x == this.x && other.y == this.y;
        }

        public Point getWinner() {
            return winner;
        }

        public boolean compute(Map<Point, Integer> map, int[][] grid, int buildings) {
            int size = q.size();

            boolean still = false;

            while (size > 0) {
                still = true;
                // add possible neighbors
                Point c = q.poll();
                List<Point> neighbors = c.getNeighbors(grid, seen);
                for (Point neighbor : neighbors ) {
                    q.add(neighbor);
                    if (map.get(neighbor) == null) {
                        map.put(neighbor, 1);
                        if(buildings == 1) {
                            winner = neighbor;
                            return false;
                        }
                    } else {
                        int count = map.get(neighbor) + 1;
                        map.put(neighbor, count);
                        if (count == buildings) {
                            winner = neighbor;
                            return false;
                        }
                    }
                }
                size--;
            }
            return still;
        }


        public int computeDistance(Point target, int[][] grid) {
            Queue<Point> q = new LinkedList<>();
            q.add(this);
            int size = q.size();

            Set<Point> seen = new HashSet<>();
            int sum = 0;


            while (size > 0) {
                // add possible neighbors
                Point c = q.poll();

                List<Point> neighbors = c.getNeighbors(grid, seen);
                for (Point neighbor : neighbors ) {
                    sum++;
                    if(neighbor.x == neighbor.x && neighbor.y == target.y){
                        return sum;
                    }
                    q.add(neighbor);
                }
                size--;
            }
            return sum;
        }


    }

    public static void main(String []args){
        int [][]grid = new int[][] {
                {1,0,2,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}};
        System.out.println(new BestHouseAroundBuildings().shortestDistance(grid));
        grid = new int[][] {
                {1,0}};
        System.out.println(new BestHouseAroundBuildings().shortestDistance(grid));
        grid = new int[][] {
                {1,0},
                {0,1}};
        System.out.println(new BestHouseAroundBuildings().shortestDistance(grid));

    }
    public int shortestDistance(int[][] grid) {
        List<Point> buildings = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    buildings.add(new Point(i, j, 0, new HashSet<>()));
                }
            }
        }

        boolean still = true;
        Map<Point, Integer> map = new HashMap<>();
        Point winner = null;

        while (still) {
            for (Point building : buildings) {
                still &= building.compute(map, grid, buildings.size());
                if (building.getWinner() != null) {
                    winner = building.getWinner();
                }
            }
        }

        System.out.println(winner);
        int sum = 0;
        if(winner != null) {
            for(Point building : buildings) {
                sum += building.computeDistance(winner, grid);
            }
        }

        return sum == 0 ? -1 : sum;

    }
}