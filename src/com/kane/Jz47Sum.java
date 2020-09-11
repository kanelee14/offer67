package com.kane;

/**
 * @program: offer67
 * @description: 求1+2+3+...+n的和
 *
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字
 * 及条件判断语句（A?B:C）
 *
 * @author: Mr.kane
 * @creater: 2020-09-10 13:59
 **/

public class Jz47Sum {

    public int sumSolution(int n) {
        int sum = 0;
//        sum = (int)(Math.pow(n,2) + n);
//        return sum>>1;
//    }
        sum += sumSolution(n - 1);
        return sum;
    }
}
