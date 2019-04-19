package searching_sorting_logarithms;

import java.util.Stack;

public class BSTIterator {


 public static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 
  private TreeNode current;
  Stack<TreeNode> s = new Stack<>();

  public BSTIterator(TreeNode node){
    pushToLeft(node);
  }

   public TreeNode next(){
     TreeNode currentMin = null;
     if(!s.isEmpty()){
       currentMin = s.pop();
       if(currentMin.right != null) {
         pushToLeft(currentMin.right);
       }
     }
    return currentMin;
}

  public void pushToLeft(TreeNode node){
    while(node != null) {
      s.push(node);
      node = node.left;
    }
  }


  public boolean hasNext(){
    return !s.isEmpty();
  }

  public static void main(String []args){
    TreeNode root = new TreeNode(3);

    TreeNode l1 = new TreeNode(3);
    l1.left = new TreeNode(1);
    l1.right = new TreeNode(4);

   TreeNode r1 = new TreeNode(15);
   r1.left = new TreeNode(9);
   r1.right = new TreeNode(21);
      root.right = r1;
      root.left = l1;

   BSTIterator it = new BSTIterator(null);
  
   while(it.hasNext()){
      System.out.println(it.next().val);
    }
 }

}
