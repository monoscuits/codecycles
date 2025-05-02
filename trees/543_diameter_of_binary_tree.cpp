

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:

    int diameter = 0;

    int diameterOfBinaryTree(TreeNode* root) {
        height(root);
        return diameter;
    }
    
    int height(TreeNode* node){
        if(node == nullptr) return 0;

        int leftH = height(node->left);
        int rightH = height(node->right);

        int dia = leftH + rightH;
        diameter = std::max(dia,diameter);

        return std::max(leftH,rightH) + 1;
    }
};