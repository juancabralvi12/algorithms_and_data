package strings;

/**
 * Created by JuanCabral on 4/21/19.
 */
public class LicenseKey {

  public static void main(String []args){
    // Input: S = "5F3Z-2e-9-w", K = 4
    // Output: "5F3Z-2E9W"
    //System.out.println(new LicenseKey().licenseKeyFormatting("---", 4));

    for(String s : "3$1$6$2$8f$2$9$1$9\n\t\t9\n\t\t\t8f".split("\n\t")){
      System.out.println(s);
    }

  }

  public String licenseKeyFormatting(String S, int K) {
    StringBuilder sb = new StringBuilder();
    StringBuilder cSb = new StringBuilder();

    for(int right = S.length() -1; right>=0; right--){
      char currentCharacter = S.charAt(right);
      if(currentCharacter != '-'){
        cSb.append(currentCharacter);
      }

      if (cSb.length() == K) {
        sb.append(cSb);
        sb.append("-");
        cSb.setLength(0);
      }

    }

    if(cSb.length() > 0) sb.append(cSb);
    else {
      if (sb.length()>0)
      sb.deleteCharAt(sb.length()-1);
    }

    return sb.reverse().toString().toUpperCase();
  }




}
