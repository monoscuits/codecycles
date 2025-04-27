/*
    For this question, Breadth First Search or BFS is the best approach to traverse a binary tree level order wise.
        Time Complexity : O(n)
        Space Complexity : O(n)
    
    Explanation:
        We are gonna use a queue which would track the tree nodes of a particular level. Right after initialization we are gonna
        offer root node to the queue and initialize a while-loop under the condition that queue is not empty. As for the logic in 
        the while-loop, we are gonna initialize a current node which would track the tree nodes so we can extract the value from 
        the nodes meanwhile we check for existence of left and right of the current node and if they exist they are added to the queue.
        These steps are repeated till the queue is empty which marks the complete traversal of the tree!

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            double currentAvg = 0;
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = queue.poll();
                currentAvg += curr.val;
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }

            }
            result.add(currentAvg/size);
        }
        return result;
    }
}
