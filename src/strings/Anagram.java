package strings;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.

 Example 1:

 Input: s = "anagram", t = "nagaram"
 Output: true
 Example 2:

 Input: s = "rat", t = "car"
 Output: false
 Note:
 You may assume the string contains only lowercase alphabets.
 */

import java.util.Map;
import java.util.HashMap;

public class Anagram {


  public static void main(String []args){
    System.out.println(isAnagram("anagram", "nagaram"));
  }

  public static boolean isAnagram(String s, String t) {
    return s.length() > t.length() ? isAnagram(s,t,0) : isAnagram(t,s,0);
  }

  public static boolean isAnagram(String s, String t, int x) {
    Map<Character, Integer> count = new HashMap<>();

    for(int i =0; i<s.length(); i++){
      count.merge(s.charAt(i), 1, (v,ss) -> v + 1);
    }

    for(int i =0; i<t.length(); i++){
      count.merge(t.charAt(i), 0, (v,ss) -> v - 1);
    }

    return !count.values().parallelStream()
      .anyMatch(pp -> pp>0);
  }


}
