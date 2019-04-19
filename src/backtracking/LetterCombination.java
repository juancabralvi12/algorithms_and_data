package backtracking;

import java.util.*;

public class LetterCombination {

 public enum Letter{
    L2("abc"),
    L3("def"),
    L4("ghi"),
    L5("jkl"),
    L6("mno"),
    L7("pqrs"),
    L8("tuv"),
    L9("wxyz");

    private String letters;

     Letter(String letters){
       this.letters = letters;
     }

    public String get(){
      return this.letters;
    }


}

  public static List<String> letterCombinations(String digits) {

        List<String> lettersList = new ArrayList<>();

        for(int i=0; i<digits.length(); i++){
            String c = String.valueOf(digits.charAt(i));

            String  letters = Letter.valueOf("L"+c).get();
            lettersList.add(letters);
        }

        return combinations(lettersList, 0);
    }

    public static List<String> combinations(List<String> letters, int level) {
        if(letters.size() == level) {
            List<String> empty = new ArrayList<>();
            empty.add("");
            return empty;
        }

        String currentLetters = letters.get(level);
        List<String> listBuilder = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<currentLetters.length(); i++){
            String c = String.valueOf(currentLetters.charAt(i));
            List<String> combs = combinations(letters, level + 1);
            for(String comb: combs) {
                sb.append(c);
                sb.append(comb);
                listBuilder.add(sb.toString());
                sb.setLength(0);
            }
        }

        return listBuilder;
    }


    public static void main(String []args) throws Exception {
        for (String sol: letterCombinations("23456789")) {
           System.out.print(sol + " ");
       }       
    }

}
