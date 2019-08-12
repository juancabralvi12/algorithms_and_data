package searching_sorting_logarithms;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:

 The number of elements initialized in nums1 and nums2 are m and n respectively.
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 Example:

 Input:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 Output: [1,2,2,3,5,6]
 */
public class MergeSortedArrays {

  public static void main(String []args){
    int []nums = new int[]{1,2,3,0,0,0};
    MergeSortedArrays.merge(nums,3, new int[]{2,5,6},3);
    System.out.println(Arrays.toString(nums));
  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int dm=0; int dn=0;
    int i=0;
    int []nums = new int[m+n];
    while(dm<m && dn<n){
      if(nums1[dm]<nums2[dn]){
        nums[i++] = nums1[dm++];
      } else {
        nums[i++] = nums2[dn++];
      }
    }

    //the remaining
    while(dm<m){
      nums[i++] = nums1[dm++];
    }

    while(dn<n){
      nums[i++] = nums2[dn++];
    }

    for(int x=0; x<nums.length; x++)
      nums1[x] = nums[x];
  }

}
