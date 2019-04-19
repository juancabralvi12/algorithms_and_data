package strings;

public class InterconvertStringInteger {

   public static void main(String []args){
     System.out.println(toInteger ("12341234"));
   }

    public static int toInteger(String s) {
       
      boolean isNegative = false;
      int remaining = 0;
      for (int i = 0; i<s.length() ; i++){
        char c = s.charAt(i);
        if (c == '-') {
          isNegative = true;
        } else {
           remaining += ((remaining + (c -'0')) * 10);
        }
        
      }

     return (isNegative) ? remaining * -1 : remaining;
    }


}
