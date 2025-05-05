/*

    For this problem, Depth First Search or DFS is the best approach.
        Time Complexity : O(n)
        Space Complexity : O(n)

    Explanation:
        We have to establish a validator method that will intake a node, a minimum and maximum integer value that a node can have. For a BST to be valid,
        elements in the left must be strictly lesser than the node and the elements in the right must be strictly greater than the node. At each node,
        we call the function for its left and right node with adjusting the minimum and maximum paramter. If any node disobeys this logic, then the method
        returns false.

*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validator(root,null,null);
    }
    public boolean validator(TreeNode node, Integer min, Integer max){
        if(node == null) return true;

        if(min != null && node.val <= min){
            return false;
        }

        if(max != null && node.val >= max){
            return false;
        }

        return validator(node.left,min,node.val) && validator(node.right,node.val,max);
    }
}
