package trees;

import java.util.*;

public class SuperBalanced {

  static class Node {
    Node left;
    Node right;
    int value;

    public Node (int value){
      this.value = value;
    }
    Node insertRight(int value){
      this.right = new Node(value);
      return right;
    }

    Node insertLeft(int value){
      this.left = new Node(value);
      return left;
    }

    public String toString(){
      return String.valueOf(value);
    }
  }

  public static List<Integer> depths = new ArrayList<>();

  public static boolean isSuperBalanced(Node node){
    isSuperBalanced(node, 0);
    return depths.size() == 1;
  }

  public static void  isSuperBalanced(Node node, int depth){

    if (node == null) {
      if (!depths.contains(depth)) {
        depths.add(depth);
      }
      return;
    }

    isSuperBalanced(node.right, depth + 1);
    isSuperBalanced(node.left, depth + 1);
  }

  public static void main(String []args){

    Node root = new Node(1);
    Node r1 = root.insertRight(2);
    //Node l2 = root.insertLeft(2);
    /*r1.insertRight(3);
    r1.insertLeft(3);
    Node l2 = root.insertLeft(2);
    l2.insertRight(3);
    l2.insertLeft(3);
    l2.isertLeft(3);*/

    System.out.println(isSuperBalanced(root));
  }


}
