/*
From leetcode.com
1163. Last Substring in Lexicographical Order - Hard

Given a string s, return the last substring of s in lexicographical order.

Example 1:

Input: "abab"
Output: "bab"
Explanation: The substrings are ["a", "ab", "aba", "abab", "b", "ba", "bab"]. The lexicographically maximum substring is "bab".
Example 2:

Input: "leetcode"
Output: "tcode"
 
Note:
1 <= s.length <= 10^5
s contains only lowercase English letters.
*/
package strings;

import java.util.*;

public class LastLexicographical{

	public static void main(String []args){
	   //System.out.println(new LastLexicographical().lastSubstring("abab"));
     //System.out.println(new LastLexicographical()
      //.lastSubstring3(""));
    //trying java 8
   /* String word = new LastLexicographical()
      .findIndexes("abab")
      .stream()
      .filter(a -> );
    System.out.println(indexes);*/
  }

  public List<Integer> findIndexes(String searchableString){
    List<Integer> indexes = new ArrayList<>();
    String keyword = String.valueOf(biggestChar2(searchableString));
    int index = searchableString.indexOf(keyword);
    while (index >=0){
      indexes.add(index);
      index = searchableString.indexOf(keyword, index+keyword.length());
    }
    return indexes;
   }

  public String lastSubstring3(String s){
      Set<Integer> indexes = getAllStartingIndexesOfAParticularCharacter(biggestChar2(s), s);
      System.out.println(indexes);
      String output = "";
      for(Integer index : indexes) {
        output = getGreater(output, s.substring(index, s.length()));
      }
      return output;
  }

  public String lastSubstring2(String s) {
    //won't work for following test case
    // incorrect --> "zvyjbgaznzayfwsaumeccpfwamfzmkinezzwobllyxktqeibfoupcpptncggrdqbkji"
    // corrent --> "zzwobllyxktqeibfoupcpptncggrdqbkji"
    //however biggestChar could be use as an optimization to 
    return s.substring(biggestChar(s),s.length());
  }
   // i    j     
  //  zaaaazzzzzazzzzzzz
  public Set<Integer> getAllStartingIndexesOfAParticularCharacter(char c, String s){
    Set<Integer> startingIndexes = new HashSet<>();
    int biggestIndex = 0;
    int i = 0;
    int currentCount = 0;
    int biggestCount = Integer.MIN_VALUE;
    int initialIndex = 0;
    while(i < s.length()){
      if(s.charAt(i) == c){
        initialIndex = i;
        currentCount = 0;
        while(i<s.length() && s.charAt(i) == c ) {
          i++;
        }
        startingIndexes.add(initialIndex);
      }
      i++; 
    }
    return startingIndexes;
  }

  public int biggestChar(String s){
    int biggest = 0;
    int current = 0;
    for(int i=0; i<s.length(); i++){
      if(biggest < (current = s.charAt(i) - 'a')){
        biggest = current;
      }
    }
    return biggest;
  }

  public char biggestChar2(String s){
    int biggest = 0;
    int current = 0;
    char biggestChar = 'a';
    for(int i=0; i<s.length(); i++){
      if(biggest < (current = s.charAt(i) - 'a')){
        biggest = current;
        biggestChar = s.charAt(i);
      }
    }
    return biggestChar;
  }


   public String lastSubstring(String s) {
    String output = "";
        for(int i=biggestChar(s); i<s.length(); i++){
            output = getGreater(output, substrings(i,"", s, ""));
        }
        return output;
    }
    
    public String substrings(int index, String current, String original, String output){
        if(index == original.length()){
            return output;
        }
        
        String newWord = current + original.charAt(index);
        return substrings(index + 1, newWord,original, 
          getGreater(newWord, current));   
    }

 	public String getGreater(String w1, String w2){
        int l1 = w1.length(); 
        int l2 = w2.length(); 

        for(int i=0; i<Math.max(l1,l2); i++){
            // if reached any of the strings
	   		    if(i==Math.min(l1,l2)){
               return l2 > l1 ? w2 : w1;
            }

           if (w1.charAt(i) == w2.charAt(i)){
             continue;
           } else if (w2.charAt(i) > w1.charAt(i)){
             return w2;
           } else {
             return w1;
           }
         }
      return w1;
    }


}
