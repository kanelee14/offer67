package com.kane;

/**
 * @program: offer67
 * @description: 数字在升序数组中出现的次数
 *
 * 统计一个数字在升序数组中出现的次数。
 *
 * @author: Mr.kane
 * @creater: 2020-08-28 16:02
 **/

public class JZ37_getNumberOfK {

    public int getNumberOfK(int [] array, int k){

        if(array == null || array.length == 0){
            return 0;
        }
        int numberOfK  = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i]  == k){
                numberOfK++;
            }
        }

        return numberOfK;
    }
}
