// https://leetcode.com/problems/maximum-number-of-ones/

package matrix;

import java.util.Queue;
import java.util.PriorityQueue;


public class MaximumNumberOfOnes {

  public static void main(String []args){
    int width = 3, height = 3, sideLength = 2, maxOnes = 1;
    new MaximumNumberOfOnes().maximumNumberOfOnes(width, height, sideLength, maxOnes);
  }

  public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
    int[][] sq = new int[sideLength][sideLength];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        sq[i % sideLength][j % sideLength]++;
      }
    }
    Queue<Integer> priorityQueue = new PriorityQueue<>((a1, a2) -> {
      return a2 - a1;
    });
    for (int i = 0; i < sideLength; i++) {
      for (int j = 0; j < sideLength; j++) {
        priorityQueue.add(sq[i][j]);
      }
    }


    int total = 0;
    for (int i = 0; i < maxOnes; i++) {
      total += priorityQueue.poll();
    }

    return total;
  }
}