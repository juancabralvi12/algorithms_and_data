package trees;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

 The successor of a node p is the node with the smallest key greater than p.val.

 Example 1:

 Input: root = [2,1,3], p = 1
 Output: 2
 Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.
 Example 2:


 Input: root = [5,3,6,2,4,null,null,1], p = 6
 Output: null
 Explanation: There is no in-order successor of the current node, so the answer is null.

 Note:

 If the given node has no in-order successor in the tree, return null.
 It's guaranteed that the values of the tree are unique.
 */
public class InOrderSuccessor {


  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    TreeNode mostLeft = mostLeft(root);
    TreeNode successor = findSecondFromRoot(root, p);
    if(mostLeft == null && successor == null) {
      return null;
    } else if(mostLeft == null || successor == null) {
      return mostLeft == null ? successor : mostLeft;
    } else {
      return mostLeft.val - p.val < successor.val - p.val ? mostLeft : successor;
    }
  }

  public TreeNode mostLeft(TreeNode root){
    if (root == null){
      return null;
    }

    while(root.left != null) {
      root = root.left;
    }

    return root;
  }

  public TreeNode findSecondFromRoot(TreeNode root, TreeNode p){
    TreeNode successor = null;

    while (root!=null) {
      if (root.val == p.val) return successor;
      if(root.val - p.val > 0){
        if(successor == null){
          successor = root;
        } else {
          if(root.val - p.val < successor.val - p.val){
            successor = root;
          }
        }
      }

      if(p.val < root.val){
        root = root.left;
      } else {
        root = root.right;
      }

    }
    return successor;
  }

  }

