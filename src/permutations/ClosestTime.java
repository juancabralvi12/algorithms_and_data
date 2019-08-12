package permutations;
/**
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.

 You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

 Example 1:

 Input: "19:34"
 Output: "19:39"
 Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
 Example 2:

 Input: "23:59"
 Output: "22:22"
 Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
 */
public class ClosestTime {

  class TimeObj implements Comparable<TimeObj> {

    String perm;
    int distance;

    public TimeObj(int distance){
      this.distance = distance;
    }

    public TimeObj(String origin, String perm){
      this.perm = perm;
      int originDistance = Integer.parseInt(origin);
      int permDistance = Integer.parseInt(perm);

      if(permDistance - originDistance < 0){
        this.distance = 2400 + (permDistance - originDistance);
      } else {
        this.distance = permDistance - originDistance;
      }

    }

    @Override
    public String toString() {
      return  perm;
    }

    @Override
    public int hashCode() {
      return perm.hashCode();
    }
    @Override
    public int compareTo(TimeObj o){
      return this.distance - o.distance;
    }
  }
  public String replace(String original, int indexToBeReplaced, char charReplacing){
    char[] charArray = original.toCharArray();
    charArray[indexToBeReplaced] = charReplacing;
    String outputString = new String(charArray);
    return outputString;
  }

  private TimeObj closer = null;

  public String nextClosestTime(String time) {
    closer = new TimeObj(Integer.MAX_VALUE);
    String filterTime = time.replace(":", "");
    calcAllPerms(filterTime,filterTime,0);
    String closest =  closer.toString();

    return closest == null ? time : new StringBuilder()
      .append(closest.substring(0,2))
      .append(":")
      .append(closest.substring(2,4))
      .toString();
  }

  private void calcAllPerms(String original, String s, int index){

    if(index == original.length()) {
      return;
    }

    for(int i=0; i<s.length(); i++){
      String ds = replace(s, index, original.charAt(i));
      TimeObj to = new TimeObj(original, ds);
      if (to.distance > 0 && to.distance < closer.distance &&
        (Integer.parseInt(ds.substring(0,2)) < 24 && Integer.parseInt(ds.substring(2,4)) < 60)){
        closer = to;
      }
      calcAllPerms(original, ds, index + 1);
    }
  }

  public static void main(String []args){
    System.out.println(new ClosestTime().nextClosestTime("19:34"));
  }


}


