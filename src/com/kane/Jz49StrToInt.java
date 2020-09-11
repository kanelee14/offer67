package com.kane;

/**
 * @program: offer67
 * @description: 把字符串转换成整数
 *
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 *
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 *
 * 示例1
 * 输入
 *  +2147483647
 *  1a33
 * 输出
 *  2147483647
 *  0
 *
 * @author: Mr.kane
 * @creater: 2020-09-10 14:11
 **/

public class Jz49StrToInt {

    public int strToInt(String str){

        if(str == null || str.length() == 0 || str.trim().equals("")){
            return 0;
        }
        char[] chars = str.trim().toCharArray();
        int res = 0;
        int flag = 1;
        int start = 0;
        int tmp = 0;
        if(chars[0] == '-'){
            flag = -1;
            start = 1;
        }
        if(chars[0] == '+'){
            start = 1;
        }
        for(int i = start; i < chars.length; i++){
            if(chars[i] > '9' || chars[i] < '0'){
                return 0;
            }
            //当前个位数字
            int digit = chars[i] - '0';
            tmp = res * 10 + digit;
            //判断正数溢出
            if(flag == 1 && res > Integer.MAX_VALUE / 10){
                return 0;
            }
            if(flag == 1 && res * 10 > Integer.MAX_VALUE - digit){
                return 0;
            }
            //判断负数溢出
            if(flag == -1 && res * flag < Integer.MIN_VALUE / 10){
                return 0;
            }
            if(flag == -1 && res * 10 * flag < Integer.MIN_VALUE + digit){
                return 0;
            }
            res = tmp;
        }
        return res * flag;
    }
}
