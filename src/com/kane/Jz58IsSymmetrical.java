package com.kane;

/**
 * @program: offer67
 * @description: 对称的二叉树
 *
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，
 * 如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的
 *
 * @author: Mr.kane
 * @creater: 2020-09-13 15:11
 **/

public class Jz58IsSymmetrical {

    public boolean isSymmetrical(TreeNode pRoot){

        if(pRoot == null){
            return true;
        }
        return comRoot(pRoot.left, pRoot.right);
    }

    private boolean comRoot(TreeNode left, TreeNode right){

        if(left == null){
            return right == null;
        }
        if(right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return comRoot(left.left, right.right) && comRoot(left.right, right.left);
    }

}
