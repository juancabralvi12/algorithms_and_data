package dynamic_programming_and_recursion;
/*
Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value 
in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and 
weights associated with n items respectively. Also given an integer W which represents knapsack capacity, find out 
the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. 
You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
*/


public class Knapsack {

    public static void main(String []args){
        System.out.println(getCapacity(100, new int[]{5,4,6,3}, new int[]{10,40,30,50}, 4));
    }

    public static int getCapacity(int w, int[] wt, int []val, int n){
        int [][]dp = new int[n+1][w+1];
        int maxProfit = Integer.MIN_VALUE;
        int max = 0; 
        for(int i=0; i<n+1; i++) dp[i][0] = 0;
        for(int j=0; j<w+1; j++) dp[0][j] = 0;

        for(int i=1; i<n+1; i++){
            for(int j=1; j<w+1; j++){
                if(wt[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    max = Math.max(dp[i-1][j], val[i-1] + dp[i-1][j-wt[i-1]]);
                    dp[i][j] = max;
                    maxProfit = Math.max(max, maxProfit);
                }
            }
        }

        return maxProfit;
    }

}