/*
Distance Between Bus Stops

A bus has n stops numbered from 0 to n - 1 that form a circle.
We know the distance between all pairs of neighboring stops where distance[i]
is the distance between the stops number i and (i + 1) % n.
The bus goes along both directions i.e. clockwise and counterclockwise.
Return the shortest distance between the given start and destination stops.

Input: distance = [1,2,3,4], start = 0, destination = 1
Output: 1
Explanation: Distance between 0 and 1 is 1 or 9, minimum is 1.
*
* */

package arrays;

class DistanceBetweenBusStops {

    public static void main(String []args){
       new DistanceBetweenBusStops().distanceBetweenBusStops(new int[]{1,2,3,4},0,1); // --> returns 1
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {        
        return Math.min(clockwiseDistance(distance, start, destination), clockwiseDistance(distance, destination, start));
    }
    
    public int clockwiseDistance(int []distance, int start, int destination){
        int sum = 0;
        int i = start; 
        int n = distance.length;
        while( i != destination){
            sum += distance[i];
            i = (i + 1) % n;
        }
        return sum;
    }
}