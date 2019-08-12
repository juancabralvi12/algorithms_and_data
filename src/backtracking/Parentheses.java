package backtracking;

import java.util.List;
import java.util.ArrayList;


public class Parentheses {

  public static void main(String []args){
    removeInvalidParentheses("(a)())()") ;
  }

  public static List<String> removeInvalidParentheses(String s) {
    helper(0,0,s,"",0);
    return null;
  }

  public static void helper(int left_count, int right_count, String original, String current, int count){
    if (count == original.length()) {
      System.out.println(current);
      return;
    }
    String c = Character.toString(original.charAt(count));
    if((right_count + (c.equals(")") ? 1 : 0)) <= (left_count + (c.equals("(")?1:0))){
      if(c.equals("(")){
        helper(left_count + 1, right_count, original, current + c, count +1);
      } else if (c.equals(")")){
        helper(left_count, right_count + 1, original, current + c, count +1);
      } else {
        helper(left_count, right_count, original, current, count + 1);
      }
    } else {
      helper(left_count, right_count, original, current, count + 1);
    }

    //helper(left_count, right_count, original, current, count + 1);

  }
}