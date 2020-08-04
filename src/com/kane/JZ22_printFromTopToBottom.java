package com.kane;

import java.util.ArrayList;

/**
 * @program: offer67
 * @description: 从上往下打印二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 * @author: Mr.kane
 * @creater: 2020-08-03 12:38
 **/

public class JZ22_printFromTopToBottom {

    public ArrayList<Integer> printFromTopToBottom(TreeNode root){

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if(root == null){
            return arrayList;
        }
        ArrayList<TreeNode>  queue = new ArrayList<>();
        queue.add(root);
        while (queue.size() != 0){
            TreeNode tmp = queue.remove(0);
            if(tmp.left != null){
                queue.add(tmp.left);
            }
            if(tmp.right != null){
                queue.add(tmp.right);
            }
            arrayList.add(tmp.val);
        }
        return  arrayList;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(0);
        TreeNode root1 = new TreeNode(8);
        TreeNode root2 = new TreeNode(6);
        TreeNode root3 = new TreeNode(10);
        TreeNode root4 = new TreeNode(5);
        TreeNode root5 = new TreeNode(7);
        TreeNode root6 = new TreeNode(9);

        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;

        root2.left = root5;
        root2.right = root6;


        JZ22_printFromTopToBottom jz22_printFromTopToBottom = new JZ22_printFromTopToBottom();
        ArrayList<Integer> result = jz22_printFromTopToBottom.printFromTopToBottom(root);
        System.out.println(result);

    }

}
