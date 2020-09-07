package com.kane;

import java.util.ArrayList;

/**
 * @program: offer67
 * @description: 何为S的两个数字
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 对应每个测试案例，输出两个数，小的先输出。
 *
 * @author: Mr.kane
 * @creater: 2020-09-07 11:00
 **/

public class Jz42FindNumbersWithSum {
    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum){

        ArrayList<Integer> arrayList = new ArrayList<>();
        if(array == null || array.length == 0){
            return arrayList;
        }

        int i = 0;
        int len = array.length - 1;
        while (i < len){
            if(array[i] + array[len] == sum){
                arrayList.add(i);
                arrayList.add(len);
                return arrayList;
            }else if(array[i] + array[len] > sum){
                len --;
            }else{
                i++;
            }
        }
        return arrayList;
    }
}
