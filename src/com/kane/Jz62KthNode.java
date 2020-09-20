package com.kane;

/**
 * @program: offer67
 * @description: 二叉搜索树的第K个节点
 *
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 *
 * @author: Mr.kane
 * @creater: 2020-09-16 15:59
 **/

public class Jz62KthNode {

    private int index = 0;
    TreeNode kthNode(TreeNode pRoot, int k){

//        必须要对每一个递归调用返回值进行判断if(node != null){return node;}，
//        判断返回值是否为null，如果为null就说明在没找到，要继续执行index++ ; if(index == k){...}的寻找过程，
//        如果返回不为空，则说明在递归调用判断子节点的时候已经找到符合要求的节点了，则将找到的节点
//        逐层向上传递返回。直到返回到第一次调用KthNode的地方。
//        如果不对递归调用的返回值做判断，即不执行
//        if(node != null){return node;}，那所找到符合 要求的节点只能返回到上一层，不能返回到顶层（可以自己调试，然后观察方法栈的调用变化
        if(pRoot != null){
            //中序遍历寻找第K个
            TreeNode node = kthNode(pRoot.left, k);
            if(node != null){
                return node;
            }
            index++;
            if(index == k){
                return pRoot;
            }
            node = kthNode(pRoot.right, k);
            if(node != null){
                return node;
            }
        }
    return null;
    }
}
