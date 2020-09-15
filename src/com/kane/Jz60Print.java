package com.kane;

import java.util.ArrayList;

/**
 * @program: offer67
 * @description: 把二叉树打印成多行
 *
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行
 *
 * @author: Mr.kane
 * @creater: 2020-09-14 18:55
 **/

public class Jz60Print {

    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot){

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        depth(pRoot, 1, arrayLists);
        return arrayLists;
    }

    public void depth(TreeNode pRoot, int depth, ArrayList<ArrayList<Integer>> arrayLists){
        if(pRoot == null){
            return;
        }
        //避免同一层的节点反复开辟Arraylist空间给list（生成了无用的空间）,
        // 同一层的节点只需要保存在list中的一个Arraylist即可
        if(depth > arrayLists.size()){
            arrayLists.add(new ArrayList<Integer>());
        }
        arrayLists.get(depth - 1).add(pRoot.val);
        depth(pRoot.left, depth + 1, arrayLists);
        depth(pRoot.right, depth + 1, arrayLists);
    }
}
