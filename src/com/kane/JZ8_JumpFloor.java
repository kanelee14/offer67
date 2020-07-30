package com.kane;

/**
 * @program: offer67
 * @description: 跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的
 * 台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @author: Mr.kane
 * @creater: 2020-07-29 17:11
 **/

public class JZ8_JumpFloor {

    /***
    * @Description: 递归：开销太大
    * @Param: [target]
    * @return: int
    * @Author: Mr.Kane
    * @Date: 2020/7/30 11:15
    */
//    public int jumpFloor(int target) {
//
//        if (target <= 2) {
//            return target;
//        }else{
//            return jumpFloor(target - 1) + jumpFloor(target - 2);
//        }
//
//    }

    public int jumpFloor(int target){

        if(target <= 2){
            return  target;
        }else{
            int f1 = 1;
            int f2 = 2;
            int f = 0;
            for(int i = 2; i < target; i++){
                f = f1 + f2;
                f1 = f2;
                f2 = f;
            }
            return f;
        }

    }

    public static void main(String[] args) {
        JZ8_JumpFloor jz8_jumpFloor = new JZ8_JumpFloor();
        int n = 5;
        int num = jz8_jumpFloor.jumpFloor(n);
        System.out.println(num);
    }
}
