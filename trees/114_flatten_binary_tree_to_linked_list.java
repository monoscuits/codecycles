/*
    Approach:
        Depth First Search is one of the best approach to solve this problem!

    Complexities:
        Time :  O(n)
        Space : O(n)

    Explanation:
        For every current node, we check if it has a left node then we traverse to find node with the largest element in that subtree 
        (also known as the rightmost leaf node) then we connect the right of the current node to the rightmost leaf node. Then we make
        current.left the new current.right and make current.left null. Then we move the current node to its right. we do this series of 
        operation while current node is not null.
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
    public void flatten(TreeNode root) {
        
        TreeNode current = root;

        while(current != null){
            if(current.left != null){
                TreeNode temp = current.left;
                while(temp.right != null){
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
}
