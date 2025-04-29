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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<List<Integer>> result = new LinkedList<>();

        if(root == null) return new ArrayList<>(result);
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            List<Integer> currentLvl = new ArrayList<>();
            for(int i =0 ; i < size ; i++){
                TreeNode current = queue.poll();
                currentLvl.add(current.val);
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
            result.addFirst(currentLvl);
        }

        return new ArrayList<>(result);

    }
}