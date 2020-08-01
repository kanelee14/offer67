package com.kane;

import com.sun.deploy.panel.ITreeNode;

import java.util.HashMap;

/**
 * @program: offer67
 * @description: 重建二叉树：
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @author: Mr.kane
 * @creater: 2020-07-26 14:37
 **/

class TreeNode{

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        this.val  = x;
    }

}

public class JZ4_reConstructBinaryTree {
    /***
    * @Description: 前序遍历：根→左→右,中序遍历：左→根→右
    * @Param: [pre, in]
    * @return: com.kane.TreeNode
    * @Author: Mr.Kane
    * @Date: 2020/7/26 15:03
    */
    public TreeNode reConstructBinaryTree(int[] pre,int [] in){
        if(pre == null || in == null){
            return null;
        }
        HashMap<Integer, Integer> hashMap  = new HashMap<Integer,Integer>();
        for (int i = 0; i < in.length; i++){
            hashMap.put(in[i], i);
        }
        return reConstructBinaryTree(pre,0, pre.length, in, 0, in.length, hashMap);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, HashMap<Integer,Integer> map){


        if(preStart >= preEnd || inStart >= inEnd){
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[preStart]);

        int index = map.get(pre[preStart]);
        int leftNum = index - inStart;
        /*
          treeNode.left = reConstructBinaryTree(pre, preStart + 1,preStart + leftNum + 1,in, inStart, index , map);
          treeNode.right = reConstructBinaryTree(pre, preStart + leftNum + 1 , preEnd,in, index + 1, preEnd, map);
         */
        reConstructBinaryTree(pre, preStart + 1,preStart + leftNum + 1,in, inStart, index , map);
        reConstructBinaryTree(pre, preStart + leftNum + 1 , preEnd,in, index + 1, preEnd, map);
        System.out.println(treeNode.val);
        return treeNode;
    }
    public static void main(String[] args) {

        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        JZ4_reConstructBinaryTree jz4_reConstructBinaryTree = new JZ4_reConstructBinaryTree();
        jz4_reConstructBinaryTree.reConstructBinaryTree(pre, in);

    }
}
