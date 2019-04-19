package trees;

import java.util.Deque;
import java.util.ArrayDeque;

public class SecondLargest {

  static class Node {
    Node left;
    Node right;
    int parentValue;
    int currentValue;

  }


  public static void main(String []args){
    
     
    Node n2 = new Node ();
    n2.parentValue = 7;
    n2.currentValue = 6;

    Node n1 = new Node ();
    n1.parentValue = 5;
    n1.currentValue = 7;
    n1.left = n2;

    Node root = new Node();
    root.currentValue = 5;
    root.right = n1;

    Node first = getLargest(root);
    
   int secondValue = -1;

    if (first.left == null){
       secondValue = first.parentValue;
    } else {
       secondValue = getLargest(first.left).parentValue;
    }

   System.out.println(secondValue);
     
} 

   private static Node getLargest(Node root){
     Deque<Node> nodes = new ArrayDeque<Node>();
     nodes.add(root);
     
     while (!nodes.isEmpty()) {
      
      Node current = nodes.pop();
       
      if (current.right == null){
         return current;
      }

      nodes.add (current.right);

     }
     return null;
  }



}

