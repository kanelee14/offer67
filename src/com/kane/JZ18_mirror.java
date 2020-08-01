package com.kane;

/**
 * @program: offer67
 * @description: 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 *
 * @author: Mr.kane
 * @creater: 2020-07-30 15:37
 **/


public class JZ18_mirror {

    public void mirror(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left == null  && root.right == null){
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left != null){
            mirror(root.left);
        }
        if(root.right != null){
            mirror(root.right);
        }
    }

}
