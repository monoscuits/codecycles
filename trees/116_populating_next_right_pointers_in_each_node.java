/*
    For this question, Breadth First Search or BFS is the best approach to traverse a binary tree level order wise.
        Time Complexity : O(n)
        Space Complexity : O(n)
*/


/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        if(root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 1 ; i <= size ; i++){
                Node current = queue.poll();
                if(i == size ){
                    current.next = null;
                }else{
                    current.next = queue.peek();
                }
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right); 
            }
        }
        return root;

    }
}
