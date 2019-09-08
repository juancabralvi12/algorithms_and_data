package heaps;

import java.util.*;
//d 1
//v 1
//f 1
//lr
//dvdf
public class MinHeap {


  public static void main(String []args){
    //["cat","bt","hat","tree"], chars = "atach"
    System.out.println(new MinHeap(10).countCharacters(new String[]{"cat","bt","hat","tree"}, "atach"));
  }

  public int countCharacters(String[] words, String chars) {
    Map<Character, Integer> charsMapping = getMappings(chars);
    int total = 0;
    for(int i=0; i<words.length; i++){
      total += compareMap(charsMapping, words[i]);
    }
    return total;
  }


  public int compareMap(Map<Character, Integer> toCompare, String chars){
    Integer ch = null;
    Map<Character, Integer> charsSet = getMappings(chars);
    for (Map.Entry<Character,Integer> entry : charsSet.entrySet()){
      if( (ch = toCompare.get(entry.getKey())) == null  || ch < entry.getValue()){
        return 0;
      }
    }
    return chars.length();
  }

  public Map<Character, Integer> getMappings(String chars){
    Map<Character, Integer> charsSet = new HashMap<>();
    for(int i=0; i<chars.length(); i++){
      Character ch = chars.charAt(i);
      if (charsSet.containsKey(ch)) {
        charsSet.put(ch, charsSet.get(ch) + 1);
      } else {
        charsSet.put(ch, 1);
      }
    }
    return charsSet;
  }

   private int[] tree;
   private int maxCapacity;
   private int index;

   /*public static void main(String []args){
      int max = 10;
      MinHeap heap = new MinHeap(max);
      for(int i=0; i<max; i++){
        heap.insert(new Random().nextInt(max));
      }
      for(int i=0; i<max; i++){
        System.out.println(heap.remove());
      }
   }*/

   public MinHeap(int maxCapacity){
      this.maxCapacity = maxCapacity;
      this.tree = new int[this.maxCapacity];
      this.index = -1;
      for(int i=0; i<this.maxCapacity; i++){
         tree[i] = -1;
       }
   }

   public void insert(int value){
     if(index == (maxCapacity-1)){
        //throw exception saying could insert
        return;
     }

     tree[++index] = value;
     int child = index;
     int parent = 0; 
     while(tree[parent = getParent(child)] > tree[child]) {
       swap(tree, child, parent);
       child = parent;
     }
  }

  public int remove(){
    if(index==-1) return -1;
    int min = tree[0];
    tree[0] = tree[index--];
    int parent = 0;
    while(canContinue(parent)){
      int lowest = getLowest(parent);
      swap(tree, lowest, parent);
      parent = lowest;
    }
    return min;
  } 

  public void swap(int []nums, int a, int b){
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;  
  }

  public boolean canContinue(int i){
    return (isLeft(i) && tree[getLeft(i)] < tree[i]) ||
           (isRight(i) && tree[getRight(i)] < tree[i]);
  }

  public int getLowest(int i){
    if(isLeft(i) && isRight(i)){
      return getLeft(i) < getRight(i) ? 
                    getLeft(i) : getRight(i);
    } 
    else if(isLeft(i)) return getLeft(i);
    else return getRight(i);
  }

  public boolean isLeft(int i){
    return getLeft(i) < maxCapacity;
  }

  public boolean isRight(int i){
    return getRight(i) < maxCapacity;
  }

  public int getLeft(int i){
    return (2*i) + 1;
  }
  
  public int getRight(int i){
     return (2*i) + 2; 
  }
 
  public int getParent(int i){
     return (i-1)/2;
  }

}
