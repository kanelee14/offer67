package com.kane;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @program: offer67
 * @description: 按之字形顺序打印二叉树
 *
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推
 *
 * @author: Mr.kane
 * @creater: 2020-09-13 15:18
 **/

public class Jz59Print {

    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot){

        ArrayList<ArrayList<Integer>> aList = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return aList;
        }

        Stack<TreeNode> s1 = new Stack<TreeNode>();
        s1.add(pRoot);
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        while(!s1.isEmpty() || !s2.isEmpty()){
          if(!s1.isEmpty()){
              ArrayList<Integer> arrayList = new ArrayList<Integer>();
              TreeNode tmp = s1.pop();
              arrayList.add(tmp.val);
              if(tmp.left != null){
                  s2.add(tmp.left);
              }
              if(tmp.right != null){
                  s2.add(tmp.right);
              }
              aList.add(arrayList);
          }else {
              ArrayList<Integer> arrayList = new ArrayList<Integer>();
              while (!s2.isEmpty()){
                  TreeNode tmp = s2.pop();

                  if(tmp.right != null){
                      s1.add(tmp.right);
                  }
                  if(tmp.left != null){
                      s1.add(tmp.left);
                  }
                  arrayList.add(tmp.val);
              }
              aList.add(arrayList);
          }
        }
        return aList;
    }

}
