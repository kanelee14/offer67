package com.kane;


/**
 * @program: offer67
 * @description: 连续子数组的最大和
 * @author: Mr.kane
 * @creater: 2020-08-04 15:09
 **/

public class JZ29_findGreatestSumOfSubArray {

    public int FindGreatestSumOfSubArray(int[] array) {
        int res = array[0];
        int max = array[0];
        for(int i = 1;i<array.length;i++){
            max = Math.max(array[i]+max,array[i]);
            res = Math.max(res,max);
        }
        return res;
    }


}
