/*
1180. Count Substrings with Only One Distinct Letter

Given a string S, return the number of substrings that have only one distinct letter.
 
Example 1:

Input: S = "aaaba"
Output: 8
Explanation: The substrings with one distinct letter are "aaa", "aa", "a", "b".
"aaa" occurs 1 time.
"aa" occurs 2 times.
"a" occurs 4 times.
"b" occurs 1 time.
So the answer is 1 + 2 + 4 + 1 = 8.

Example 2:

Input: S = "aaaaaaaaaa"
Output: 55

*/
package strings;
import java.util.Map;
import java.util.HashMap;


public class CountDistinctSubstrings {

    public static Map<Integer, Integer> lengths = new HashMap<>();
    public static int length(int n){
        if (lengths.containsKey(n)){
            return lengths.get(n);
        }
        int count = 0;
        for (int i=1; i<n+1; i++){
            count += i;
        }
        lengths.put(n, count);
        return count;
    }
    public static void main(String []args){
        // 1 --> 10
        // 2 --> 9
        // 3 --> 8 
        // 4 --> 7
        System.out.println(length("aaaaaaaaaa".length()));
    }
}