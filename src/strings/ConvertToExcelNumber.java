package strings;

/**
 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 ...
 Example 1:

 Input: "A"
 Output: 1
 Example 2:

 Input: "AB"
 Output: 28
 Example 3:

 Input: "ZY"
 Output: 701
 */
public class ConvertToExcelNumber {

  public int convertToInt(char c){
    return c - 64;
  }

  public int titleToNumber(String s) {
    int baseIndex = 0;
    int total = 0;
    for(int i=s.length()-1; i>=0; i--,baseIndex++){
      total+= (Math.pow(26,baseIndex) * convertToInt(s.charAt(i)));
    }
    return total;
  }

}
