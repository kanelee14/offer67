package com.kane;

/**
 * @program: offer67
 * @description: 平衡二叉树
 *
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 *
 * @author: Mr.kane
 * @creater: 2020-08-28 16:07
 **/

public class JZ39_isBalancedTree {

    private boolean isBalanced = true;
    public boolean isBalancedTree(TreeNode root){

        getDepth(root);
        return isBalanced;
    }
    private int getDepth(TreeNode root){

        if(root == null){
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if(Math.abs(left - right) > 1){
            isBalanced = false;
        }
        left++;
        right++;
        return Math.max(left, right);
    }
}
