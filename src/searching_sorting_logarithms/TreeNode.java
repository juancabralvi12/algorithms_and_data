package searching_sorting_logarithms;

public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }

  public static void preload(TreeNode node){
    if (node == null) return ;

    preload(node.right);
    preload(node.left);

    System.out.println(node.val);
  }

  public static void main(String []args){
    TreeNode root = new TreeNode(7);
    root.left = new TreeNode(3);
    root.right = new TreeNode(15);

    preload(root);
  }

}




