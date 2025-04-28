/*
    For this question, Breadth First Search or BFS is the best approach to traverse a binary tree level order wise.
        Time Complexity : O(n)
        Space Complexity : O(n)
    
    Explanation:
        We are gonna use Breadth First Search Algorithm but with a twist. we are gonna use a Deque or list to store the values of a level 
        and we are gonna store a level in a normal manner while storing the next and previous level is stored in reverse. this type of storing 
        gives a sense of zig-zag traversal as expected in the question! The reason to use a Deque instead of list in the code below is to avoid 
        the O(N^2) complexity by the usage of Deque which would take O(1) time to store an element in front!

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);

        // checker for reverse
        boolean reverse = false;
        while(!queue.isEmpty()){

            int size = queue.size();
            Deque<Integer> currLvl = new LinkedList<>();
            for(int i =0 ; i < size ; i++){
                    
                TreeNode current = queue.pollFirst();
                
                
                if(reverse){
                    currLvl.addFirst(current.val);
                }else{
                    currLvl.add(current.val);
                }
                if(current.left != null) queue.offerLast(current.left);
                if(current.right != null) queue.offerLast(current.right);
            } 
            result.add(new ArrayList<>(currLvl));
            reverse = !reverse;
        }
        return result;
    }
}
