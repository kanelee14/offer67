package com.kane;

/**
 * @program: offer67
 * @description: 数组中出现次数超过一半的数字
 * @author: Mr.kane
 * @creater: 2020-08-04 15:08
 **/

public class JZ28_moreThanHalfNum_Solution {

    public int moreThanHalfNum_Solution(int [] array) {

        int len = array.length;
            if(len<1){
            return 0;
        }
        int count = 1;
        int num = array[0];
        //超过一半，肯定存在两个相同的数字挨在一起
            for(int i=1;i<len;i++){
            if(array[i]==num){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                num=array[i];
                count=1;
            }
        }
        count = 0;
            for(int i=0;i<len;i++){
            if(array[i]==num){
                count++;
            }
        }
            if(count*2>len){
            return num;
        }
            return 0;
    }
}
