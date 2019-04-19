package searching_sorting_logarithms;

public class BinaryFindRotationPoint {
     public static void main(String []args){
	System.out.println(compare(args[0],args[1]));

       Math.round(1/2.0);
    int r = 1;
   int l = 2;
      Math.round((r+l)/2.0);
}


public static boolean compare(String s1, String s2){
        int i=0;
        int j=0;
        for(; i<s1.length() || j<s2.length(); i++,j++){
            System.out.println("f: "+ (int)s1.charAt(i) + " s: " + (int)s2.charAt(j));
            if((int)s1.charAt(i) > (int)s2.charAt(j)) return true;
            else if ((int)s1.charAt(i) < (int)s2.charAt(j)){
return false;
}
        }
        
        return j > i ? true : false;
    }

}
