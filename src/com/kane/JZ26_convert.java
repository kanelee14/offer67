package com.kane;

/**
 * @program: offer67
 * @description: 二叉搜索数与双向链表
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * @author: Mr.kane
 * @creater: 2020-08-04 15:12
 **/


/*
解题思路：
    1.将左子树构造成双链表，并返回链表头节点。
    2.定位至左子树双链表最后一个节点(新增一个全局变量记录左子树的最后一个节点)。
    3.如果左子树链表不为空的话，将当前root追加到左子树链表。
    4.将右子树构造成双链表，并返回链表头节点。
    5.如果右子树链表不为空的话，将该链表追加到root节点之后。
    6.根据左子树链表是否为空确定返回的节点。
    */


public class JZ26_convert {

     TreeNode leftLast = null;
    public TreeNode convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        if(pRootOfTree.left == null && pRootOfTree.right == null){
            // 最后的一个节点可能为最右侧的叶节点
            leftLast = pRootOfTree;
            return pRootOfTree;
        }
        // 将左子树构造成双链表，并返回链表头节点
        TreeNode left = convert(pRootOfTree.left);
        if(left != null){
            leftLast.right = pRootOfTree;
            pRootOfTree.left = leftLast;
        }
        // 当根节点只含左子树时，则该根节点为最后一个节点
        leftLast = pRootOfTree;
        // 将右子树构造成双链表，并返回链表头节点
        TreeNode right = convert(pRootOfTree.right);
        // 如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right != null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left != null ? left : pRootOfTree;
    }
}
