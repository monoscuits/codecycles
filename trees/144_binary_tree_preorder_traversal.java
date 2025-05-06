/*
    Approach:
        Pre-Order Traversal as the problem suggests
        
    Time Complexity  : O(n)
    Space Complexity : O(n)

    Explanation:

        We are using a stack to store the values as we do pre order traversal through iteration
    

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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            
            TreeNode current = stack.pop();
            result.add(current.val);

            if(current.right != null) stack.push(current.right);
            if(current.left != null) stack.push(current.left);
            
        }
        return result;
    }
    
}
