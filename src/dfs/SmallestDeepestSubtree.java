/*
865. Smallest Subtree with all the Deepest Nodes

Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.
A node is deepest if it has the largest depth possible among any node in the entire tree.
The subtree of a node is that node, plus the set of all descendants of that node.
Return the node with the largest depth such that it contains all the deepest nodes in its subtree


Example 1:

Input: [3,5,1,6,2,0,8,null,null,7,4]
Output: [2,7,4]
Explanation:

        3
    /       \
   5         1
  /  \      /  \
6     2    0    8
     /  \
    7    4

We return the node with value 2, colored in yellow in the diagram.
The nodes colored in blue are the deepest nodes of the tree.
The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of the given tree.
The output "[2, 7, 4]" is a serialization of the subtree rooted at the node with value 2.
Both the input and output have TreeNode type.
 

Note:

The number of nodes in the tree will be between 1 and 500.
The values of each node are unique.

*/


package dfs;

public class SmallestDeepestSubtree {



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
   }
    
    public TreeNode best = null;
    public int max = Integer.MIN_VALUE;
    
    public int dfs(TreeNode root, int depth){
        if (root == null) return depth;

        int l = dfs(root.left, depth + 1);
        int r = dfs(root.right, depth +1);

        //System.out.println(String.format("l = dfs(%s,%s)= %s", root.val, depth, l));
        //System.out.println(String.format("r = dfs(%s,%s)= %s", root.val, depth, r));

        if(l == r && l>=max) {
            best = root;
            max = l;
        } else if (root.right == null && root.left == null && depth > max) {
            best = root;
            max = depth;
        }



        return l > r ? l : r;

    }
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return best;
    }

    /*
        3
    /       \
   5         1
  /  \      /  \
6     2    0    8
     /  \
    7    4
    */
    public static void main(String []args){
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(5);
        TreeNode r1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(6);
        TreeNode r21 = new TreeNode(2);
        TreeNode l22 = new TreeNode(0);
        TreeNode r22 = new TreeNode(8);
        TreeNode l31 = new TreeNode(7);
        TreeNode r31 = new TreeNode(4);

        TreeNode rlast = new TreeNode(100);
        root.left = l1;
        root.right = r1;
        l1.left = l21;
        l1.right = r21;
        r21.left = l31;
        r21.right = r31;
        r1.left = l22;
        r1.right = r22;
        l31.left = rlast;

        System.out.println(new SmallestDeepestSubtree().subtreeWithAllDeepest(root).val);
    }

}