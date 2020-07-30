package com.kane;

/**
 * @program: offer67
 * @description: 斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列
 * 的第n项（从0开始，第0项为0，第1项是1
 * @author: Mr.kane
 * @creater: 2020-07-29 17:11
 **/

public class JZ7_fibonacci {

    public int fibonacci(int n){

        if(n == 0 || n == 1){
            return  n ;
        }else {
            return fibonacci(n-1) + fibonacci(n -2);
        }

    }

    public static void main(String[] args) {
        int n = 6;
        JZ7_fibonacci jz7_fibonacci = new JZ7_fibonacci();
        int num = jz7_fibonacci.fibonacci(n);
        System.out.println(num);
    }
}
