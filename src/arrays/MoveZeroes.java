/*
*
from leetcode.com
283. Move Zeroes

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:


Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
*
* [0,1,0,3,12]

*
* n 1
* z 0
* [1,0,0,3,12]
* z 1
* n 3
* [1,3,0,0,12]
* z = 2
* n = 4
* [1,3,12,0,0]
*
*
* 1. z = findZ(0)
* 2. n = findN(0)
* while n < nums.length && z < nums.length
*
* 3. if z < n
*      swap(nums, z, n)
*      z = findZ(z)
* 4. n = findN(n)
*
* find --> should return nums.length + 1 if not found
*
Note:

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.

* */
package arrays;

public class MoveZeroes {

    public static void main(String []args){
        int []nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        print(nums);

        nums = new int[]{0,0,0,0,0,0};
        moveZeroes(nums);
        print(nums);

        nums = new int[]{1,2,3,4,5,0};
        moveZeroes(nums);
        print(nums);

        nums = new int[]{1,2,3,4,0,5};
        moveZeroes(nums);
        print(nums);

        nums = new int[]{0,1,2,3,4,0,5};
        moveZeroes(nums);
        print(nums);
    }

    public static void print(int []nums){
        StringBuilder sb = new StringBuilder("[");
        for (int n : nums) sb.append(n).append(",");
        sb.delete(sb.length() - 1, sb.length());
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static int findZ(int []nums, int idx){
        for(int i=idx; i<nums.length; i++){
            if (nums[i] == 0) return i;
        }
        return nums.length + 1;
    }

    public static int findN(int []nums, int idx){
        for(int i=idx; i<nums.length; i++){
            if (nums[i] != 0) return i;
        }
        return nums.length + 1;
    }


    public static void swap(int []nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void moveZeroes(int[] nums) {

        int z = findZ(nums, 0);
        int n = findN(nums, 0);
        while (n < nums.length && z < nums.length) {
            if (z < n){
                swap(nums, z, n);
                z = findZ(nums, z);
            }
            n = findN(nums, z);
        }
    }


}
