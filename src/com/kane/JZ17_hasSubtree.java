package com.kane;

/**
 * @program: offer67
 * @description: 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构
 * @author: Mr.kane
 * @creater: 2020-07-30 15:37
 **/

public class JZ17_hasSubtree {

    public boolean hasSubtree(TreeNode root1, TreeNode root2){

        boolean result = false;
        if(root1 != null && root2 != null){
            if(root1.val == root2.val){
                result = doesTwoNodehaveSubtree(root1, root2);
            }
            if(result == false){
                result = hasSubtree(root1.left, root2);
            }
            if(result == false){
                result  = hasSubtree(root1.right, root2);
            }
        }

        return result;
    }

    public boolean doesTwoNodehaveSubtree(TreeNode node1, TreeNode node2){
        if(node2 == null){
            return true;
        }
        if(node1 == null){
            return false;
        }
        if(node1.val != node2.val){
            return false;
        }
        return doesTwoNodehaveSubtree(node1.left, node2.left) && doesTwoNodehaveSubtree(node1.right, node2.right);
    }


    public static void main(String[] args) {


        TreeNode root1 = new TreeNode(0);
        TreeNode pNode1 = root1;
        pNode1.left = new TreeNode(8);
        pNode1 = root1.left;
        pNode1.left = new TreeNode(9);
        pNode1 = root1.left;
        pNode1.left = new TreeNode(2);
        pNode1 = root1.left;
        pNode1.left = new TreeNode(5);


        TreeNode root2 = new TreeNode(8);



        boolean result = false;
        JZ17_hasSubtree jz17_hasSubtree = new JZ17_hasSubtree();
        result = jz17_hasSubtree.hasSubtree(root1, root2);
        System.out.println(result);
    }
}
