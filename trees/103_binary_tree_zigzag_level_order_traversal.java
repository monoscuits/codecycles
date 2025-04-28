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