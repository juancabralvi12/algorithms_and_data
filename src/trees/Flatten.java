/*
* Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6

The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

* */

package trees;

public class Flatten {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void flatten(TreeNode root) {
        helper(root);
    }

    public TreeNode helper(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);

        if(left != null) {
            root.right = left;
            while(left.right !=null)
                left = left.right;
            left.right = right;
            root.left = null;
        }

        return root;

    }

}
