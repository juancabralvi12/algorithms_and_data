import java.util.*;

class SubArraySumToK {
    
    // k = 3
    // s = 1
    
                 
     //       4  -2 
     //   -1 -1  -3
    // 1   0  5   3
    //[1, -1, 5, -2, 3]

    public static void main(String []args){
        System.out.println(maxSubArrayLen2(new int[]{1,5}, 4 ));
    }


    public static int maxSubArrayLen2(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length, maxLen = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (sum == k)
                maxLen = i + 1;
            else {
                if (map.get(sum - k) != null)
                    maxLen = Integer.max(maxLen, i - map.get(sum - k));
            }
            if (map.get(sum) == null)
                map.put(sum, i);
        }
        return maxLen;
    }
    
    public int maxSubArrayLen(int[] nums, int k) {
        max = 0;
        maxSubArrayLen(nums, k, nums.length -1, 0);
       return max;
    }
    
    int max = Integer.MIN_VALUE;
    Map<String, Integer> memo = new HashMap<>();
    
    public int maxSubArrayLen(int[] nums, int k, int pos, int limit){
        
        if(pos == limit) {
           return nums[pos];
        }

        int sum = 0;
        
        for(int i=pos; i>=0; i--) {
            for(int idx=0; idx<i; idx++){
                
                String hashCode = String.format("[%s...%s]", i -1, idx);
                
                if (memo.get(hashCode) != null) {
                    sum = nums[i] + memo.get(hashCode);
                } else { 
                    sum = nums[i] + maxSubArrayLen(nums, k, i -1, idx);
                    memo.put(hashCode, sum);
                }
                
                int deep = (i - idx);
                
                 System.out.println(String.format("sum: [%s...%s] = %s, deep: %s", idx, i, sum, deep));
                
                if(sum == k && deep > max) {
                    max = deep;
                }
            }
        }
        return sum;
    }
    
}