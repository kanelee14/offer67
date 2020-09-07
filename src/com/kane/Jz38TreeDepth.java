package com.kane;

/**
 * @program: offer67
 * @description: 二叉树的深度
 *
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * @author: Mr.kane
 * @creater: 2020-08-28 16:05
 **/

public class Jz38TreeDepth {

    public int treeDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int rootLeft = treeDepth(root.left);
        int rootRight = treeDepth(root.right);
        return rootLeft > rootRight ? rootLeft + 1 : rootRight + 1;
    }
}
