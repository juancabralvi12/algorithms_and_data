package searching_sorting_logarithms;


public class FindRotationPoint {


    public static boolean isTheSecondStringAlfabeticallyLessThanTheFirstOne(String w1, String w2){
        int l1 = w1.length(); 
        int l2 = w2.length(); 


        for(int i=0; i<Math.max(l1,l2); i++){
	   if(i==Math.min(l1,l2)){
              return l2 > l1; 
            }

           if (w1.charAt(i) == w2.charAt(i)){
             continue;
           } else if (w2.charAt(i) < w1.charAt(i)){
             return true;
           } else {
             return false;
           }
         }

      return false;
    }

    public static String findRotationPoint(String []words){
       for (int i= 0; i<words.length; i++){
           if (isTheSecondStringAlfabeticallyLessThanTheFirstOne(words[i], words[i+1])){
            return words[i+1];
             }
}

return null;
   }

    public static void main(String []args){
         //System.out.println(isTheSecondStringAlfabeticallyLessThanTheFirstOne("a","b"));
         //System.out.println(isTheSecondStringAlfabeticallyLessThanTheFirstOne("b","a"));
//System.out.println(isTheSecondStringAlfabeticallyLessThanTheFirstOne("b","aaaaaaaa"));

  String[] words = new String[]{
    "ptolemaic",
    "retrograde",
    "supplant",
    "undulate",
    "xenoepist",
    "asymptote",  // <-- rotates here!
    "babka",
    "banoffee",
    "engender",
    "karpatka",
    "othellolagkage",
};

System.out.println(findRotationPoint(words));

    }


}


