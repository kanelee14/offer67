package com.kane;

import java.util.Stack;

/**
 * @program: offer67
 * @description: 两个栈实现队列
 * @author: Mr.kane
 * @creater: 2020-07-29 14:21
 **/

public class JZ5_twoStackTranformQunue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /***
    * @Description: 入队
    * @Param: [node]
    * @return: void
    * @Author: Mr.Kane
    * @Date: 2020/7/29 17:19
    */
    public void push(int node){
        stack1.push(node);
    }

    /***
    * @Description: 出队
    * @Param: []
    * @return: void
    * @Author: Mr.Kane
    * @Date: 2020/7/29 17:19
    */
    public int pop(){
        while (stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException("Qunue is empty!");
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int temp = stack2.pop();

        // stack2 出栈的其他都要在stack1再入栈
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return temp;
    }

    public static void main(String[] args) {

        JZ5_twoStackTranformQunue jz5_twoStackTranformQunue = new JZ5_twoStackTranformQunue();
        jz5_twoStackTranformQunue.push(1);
        jz5_twoStackTranformQunue.push(2);
        jz5_twoStackTranformQunue.push(3);

        System.out.println(jz5_twoStackTranformQunue.pop());
        System.out.println(jz5_twoStackTranformQunue.pop());
        System.out.println(jz5_twoStackTranformQunue.pop());
        System.out.println(jz5_twoStackTranformQunue.pop());
    }

}
