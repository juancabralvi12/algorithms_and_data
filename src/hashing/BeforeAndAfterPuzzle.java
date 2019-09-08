/**
 *
 from leetcode.com
 5068. Before and After Puzzle

 Given a list of phrases, generate a list of Before and After puzzles.
 A phrase is a string that consists of lowercase English letters and spaces only. No space appears in the start or the end of a phrase. There are no consecutive spaces in a phrase.
 Before and After puzzles are phrases that are formed by merging two phrases where the last word of the first phrase is the same as the first word of the second phrase.
 Return the Before and After puzzles that can be formed by every two phrases phrases[i] and phrases[j] where i != j. Note that the order of matching two phrases matters, we want to consider both orders.
 You should return a list of distinct strings sorted lexicographically

 Example 1:

 Input: phrases = ["writing code","code rocks"]
 Output: ["writing code rocks"]
 Example 2:

 Input: phrases = ["mission statement",
 "a quick bite to eat",
 "a chip off the old block",
 "chocolate bar",
 "mission impossible",
 "a man on a mission",
 "block party",
 "eat my words",
 "bar of soap"]
 Output: ["a chip off the old block party",
 "a man on a mission impossible",
 "a man on a mission statement",
 "a quick bite to eat my words",
 "chocolate bar of soap"]
 Example 3:

 Input: phrases = ["a","b","a"]
 Output: ["a"]

 */

package hashing;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;

public class BeforeAndAfterPuzzle {

  public List<String> beforeAndAfterPuzzles(String[] phrases) {
    List<String> result = new ArrayList<>();
    Map<String, List<Integer>> idxs = new HashMap<>();
    for(int i=0; i<phrases.length; i++){
      String f = phrases[i].split(" ")[0];
      idxs.putIfAbsent(f, new ArrayList());
      idxs.get(f).add(i);
    }

    for(int j=0; j<phrases.length; j++){
      String p = phrases[j];
      String l = last(p);
      if(idxs.get(l)!=null){
        for(Integer i : idxs.get(l)){
          if(i!=j){
            String p1 = combine(phrases[j], phrases[i], l);
            if(!result.contains(p1)){
              result.add(p1);
            }
          }
        }
      }
    }
    Collections.sort(result);
    return result;

  }

  public String combine(String s1, String s2, String r){
    StringBuilder sb = new StringBuilder(s1);
    sb.append(s2.substring(r.length(), s2.length()));
    return sb.toString();
  }

  public String last(String w){
    String []ws = w.split(" ");
    return ws[ws.length-1];
  }

}
