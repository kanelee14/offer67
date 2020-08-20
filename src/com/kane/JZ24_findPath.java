package com.kane;

import java.util.ArrayList;

/**
 * @program: offer67
 * @description: 二叉树中和为某一值的路径
 *
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * @author: Mr.kane
 * @creater: 2020-08-04 15:04
 **/


public class JZ24_findPath {

    private ArrayList<ArrayList<Integer>>  listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target){

        if (root == null){
            return listAll;
        }

        list.add(root.val);
        target -= root.val;

        if(target == 0 && root.left == null && root.right == null){
            listAll.add(new ArrayList<Integer>(list));
        }

        findPath(root.left, target);
        findPath(root.right, target);
        return listAll;
    }
}
