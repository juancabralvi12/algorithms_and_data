/*
  From leetcode.com -> problem 53. Maximum Subarray

 Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
* */
package dynamic_programming_and_recursion;

public class MaximumSubarray {

  public static void main(String []args){
    System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})); //prints 6
  }

  public static int maxSubArray(int[] nums) {
    int maxValue = Integer.MIN_VALUE;
    int sum = 0;

    for(int i=0; i<nums.length; i++){
      if(nums[i] + sum > nums[i]){
        sum += nums[i];
      } else {
        sum = nums[i];
      }
      maxValue = Math.max(sum, maxValue);
    }
    return maxValue;
  }

}
