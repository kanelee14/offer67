package com.kane;


import java.util.Iterator;
import java.util.Stack;

/**
 * @program: offer67
 * @description: 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数
 * （时间复杂度应为O（1）
 * 测试用例:
 * [“PSH3”,”MIN”,”PSH4”,”MIN”,”PSH2”,”MIN”,”PSH3”,”MIN”,”POP”,”MIN”,”POP”,”MIN”,”POP”,”MIN”,”PSH0”,”MIN”]
 * 对应输出应该为:
 * 3,3,2,2,2,3,3,0
 * @author: Mr.kane
 * @creater: 2020-07-30 15:39
 **/

public class JZ20_minFunctionOfStack {


    //迭代器 iterator
   /* Integer temp = null;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int node){

        stack.push(node);
    }

    public void pop(){
        stack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int minFunctionOfStack(){
        int min = stack.peek();
        int tmp = 0;
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()){
            tmp = iterator.next();
            if(min > tmp){
                min = tmp;
            }
        }
        return min;
    }*/

   Integer tmp = null;
   Stack<Integer> min = new Stack<Integer>();
   Stack<Integer> stack = new Stack<Integer>();

   public void push(int node){
       if (tmp!= null) {//如果栈中已经有数据
           if(node <= tmp){//和之前的最小值进行比较
               min.push(node);//若node不大于之前的最小值，就将之push到min栈中
               tmp = node;
           }
           stack.push(node);//进行主栈基础的数据push
       }else {
           tmp = node;
           stack.push(node);
           min.push(node);
       }
    }
    public void pop(){
       int num = min.pop();
       if(stack.pop() != num){
           //此处主栈已经进行了pop操作
           min.push(num);
       }
    }

    public int top(){
       int num = stack.peek();
       return  num;
    }

    public int min(){
       //获取min栈栈顶元素即可
       int num = min.peek();
       return  num;
    }
}
