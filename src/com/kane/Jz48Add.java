package com.kane;

/**
 * @program: offer67
 * @description: 不用加减乘除做加法
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * @author: Mr.kane
 * @creater: 2020-09-10 14:06
 **/

public class Jz48Add {

    public int add(int num1, int num2){

        if(num2 == 0){
            return num1;
        }
        int sum = num1 ^ num2;
        int target = (num1 & num2) << 1;
        return add(sum, target);
    }
}
