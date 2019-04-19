package searching_sorting_logarithms;

class BST {

static  class Node {
	Node left;
        Node right;
        int val;
  }


 int find_min(Node root,int v, int min){
	if(root == null) {
           return Integer.MAX_VALUE;
        }

      if (root.val > v){
      	min = Math.min(min, root.val);   
      }
      
     return Math.min(Math.min(find_min(root.left,v, min), find_min(root.right,v, min)), min);
 }


public static void main(String []args){
    Node root = new Node();
    root.val = 2;
   
   Node left = new Node();
   left.val = 1;

   Node right = new Node();
   right.val = 3;

   root.left = left;
   root.right = right;

   System.out.println(new BST().find_min(root,Integer.valueOf( args[0]), Integer.MAX_VALUE));

 }


}


