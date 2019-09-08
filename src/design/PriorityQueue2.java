package design;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by JuanCabral on 19/08/19.
 */
public class PriorityQueue2<T> {

  public static void main(String []args){
    PriorityQueue2<Integer> q = new PriorityQueue2<>(new Comparator2<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return 0;
      }
    });
  }

  public PriorityQueue2(Comparator2<T> comparator2){

  }

}
