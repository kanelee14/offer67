package com.kane;

/**
 * @program: offer67
 * @description: 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author: Mr.kane
 * @creater: 2020-07-29 17:12
 **/

public class JZ9_jumpFloorII {

    public int jumpFloorII(int target){

        int sum = 1;
        if(target == 0 || target == 1){
            return target;
        }else {
            while(target > 1){
                sum += jumpFloorII(target - 1);
                target--;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        JZ9_jumpFloorII jz9_jumpFloorII = new JZ9_jumpFloorII();
        int n = 5;
        int num = jz9_jumpFloorII.jumpFloorII(n);
        System.out.println(num);
    }

}
