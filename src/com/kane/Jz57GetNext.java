package com.kane;

/**
 * @program: offer67
 * @description: 二叉树的下一个结点
 *
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 中序遍历首先遍历左子树，然后访问根结点，最后遍历右子树
 *
 * 1.二叉树为空，则返回空；
 * 2.节点右孩子存在，则设置一个指针从该节点的右孩子出发，一直沿着指向左子结点的指针找到的叶子节点即为下一个节点；
 * 3.节点不是根节点。如果该节点是其父节点的左孩子，则返回父节点；否则继续向上遍历其父节点的父节点，重复之前的判断，返回结果。
 *
 * @author: Mr.kane
 * @creater: 2020-09-13 14:48
 **/
public class TreeLinkNode{
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val){
        this.val = val;
    }
}

public class Jz57GetNext {

    public TreeLinkNode  getNext(TreeLinkNode pNode){

        if(pNode == null){
            return null;
        }
        if(pNode.next != null){
            pNode = pNode.right;
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        while (pNode.next != null){
            if(pNode.next.left == pNode){
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
