package com.kane;

import java.util.Stack;

/**
 * @program: offer67
 * @description: 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * @author: Mr.kane
 * @creater: 2020-08-01 15:56
 **/

public class JZ21_isPopOrder {

    public  boolean isPopOrder(int [] pushA, int [] popA){

        if(pushA == null || popA == null){
            return false;
        }
        Stack<Integer> temp = new Stack<Integer>();

        int popIndex = 0;
        for(int i = 0; i < pushA.length; i++){
            temp.push(pushA[i]);
            while ((!temp.empty() && (temp.peek() == popA[popIndex]))){
                temp.pop();
                popIndex++;
            }
        }

        return temp.empty();
    }

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};

        JZ21_isPopOrder jz21_isPopOrder = new JZ21_isPopOrder();
        Boolean result = jz21_isPopOrder.isPopOrder(pushA, popA);
        System.out.println(result);
    }
}
