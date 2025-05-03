/* Approach:
	Breadth First Search is the suitable algorithm for this problem
  
   Complexities:
	Time  : O(n)
	Space : O(n)

  Explanation:
	We keep track of the nth level by iniatilizing a boolean value namely "OddLevel". Everytime we are in a oddlevel of the tree, we create an arraylist
	and add the nodes of oddlevel in it and once after the completion of odd level traversal, we reverse the values of the nodes with the help of the arraylevel

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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null) return null;

        Deque<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.offerLast(root); 

        boolean oddLvl = false;
        while(!treeQueue.isEmpty()){
            int size = treeQueue.size();
            ArrayList<TreeNode> list = new ArrayList<>();

            for(int i = 0; i < size ; i++){
                TreeNode current = treeQueue.pollFirst();
                list.add(current);

                if(current.left != null){
                    treeQueue.offerLast(current.left);                    
                }
                if(current.right != null){
                    treeQueue.offerLast(current.right);
                }
            }

            if(oddLvl){
                int left = 0, right = list.size() - 1;
                while(left < right){
                    int temp = list.get(right).val;
                    list.get(right).val = list.get(left).val;
                    list.get(left).val = temp;
                    left++ ; right--;
                }
            }
            oddLvl = !oddLvl;
        }
        return root;
    }
}
