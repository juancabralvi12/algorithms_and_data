/*

from leetcode.com
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
* */

package hashing;

import java.util.Map;
import java.util.HashMap;

public class CountSubstringsOneDistinctLetter {

  public Map<Integer, Integer> map = new HashMap<>();
  public int countLetters(String S) {
    int count = 0;
    int j = 0;
    int i = 0;
    while(j<S.length()){
      if(S.charAt(j) != S.charAt(i)){
        count += compute(j-i);
        i = j;
      }
      compute(j-i);
      j++;
    }
    count += compute(j-i);
    return count;
  }



  public int compute(int n){
    if(map.containsKey(n)) {return map.get(n);}
    else if(n == 1) {map.put(1,1); return 1;}
    else if(n == 0) { map.put(0,0); return 0;}
    else {
      int r = n + map.get(n-1);
      map.put(n,r);
      return r;
    }
  }

}
