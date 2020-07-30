package com.kane;

/**
 * @program: offer67
 * @description: 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形
 * 无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @author: Mr.kane
 * @creater: 2020-07-29 17:12
 **/

public class JZ10_rectCover {

    public int rectCover(int target){


        if(target == 1 || target == 0 || target == 2){
            return target;
        } else {
          return rectCover(target - 1) + rectCover(target - 2);
        }
    }

    public static void main(String[] args) {

        int n = 6;
        JZ10_rectCover jz10_rectCover = new JZ10_rectCover();
        int result = jz10_rectCover.rectCover(n);
        System.out.println(result);
    }
}
