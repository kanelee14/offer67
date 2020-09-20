package com.kane;

import java.util.ArrayList;

/**
 * @program: offer67
 * @description: 滑动窗口的最大值
 *
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 窗口大于数组长度的时候，返回空
 *
 * @author: Mr.kane
 * @creater: 2020-09-16 17:17
 **/

public class Jz64MaxInWindows {

    public ArrayList<Integer> maxInWindows(int [] num, int size){

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if(num == null || num.length == 0 || num.length < size || size == 0){
            return arrayList;
        }
        int len = num.length;

        int i = 0;
        while(i < len - size + 1){
            int max = num[i];
            for(int j = i; j < size; j++){
                if(max < num[j]){
                    max = num[j];
                }
            }
            arrayList.add(max);
            i++;
        }
        return arrayList;
    }
}
