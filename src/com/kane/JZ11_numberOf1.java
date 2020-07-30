package com.kane;

/**
 * @program: offer67
 * @description: 二进制中1的个数
 * 输入一个整数，输出该数32位二进制表示中1的个数。
 * 其中负数用补码表示。
 *
 * 原码：原码就是符号位加上真值的绝对值
 * 反码：正数的反码是其本身，负数的反码是在其原码的基础上, 符号位不变，其余各个位取反
 * 补码：正数的补码就是其本身，负数的补码是在其原码的基础上, 符号位不变, 其余各位取反, 最后+1
 * Eg:-1
 * 原码 1000 0001
 * 反码 1111 1110
 * 补码 1111 1111
 *
 * @author: Mr.kane
 * @creater: 2020-07-30 11:19
 **/

public class JZ11_numberOf1 {

    public int numberOf1(int n){

        int count = 0;
        int index = 1;
        while(index != 0){
            if((n & index) != 0){
                count++;
            }
            index = index << 1;
        }
        return count;
    }

    public static void main(String[] args) {
        JZ11_numberOf1 jz11_numberOf1 = new JZ11_numberOf1();
        int inputNum = -1;
        System.out.println(jz11_numberOf1.numberOf1(inputNum));

    }
}
