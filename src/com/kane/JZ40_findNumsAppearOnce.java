package com.kane;

/**
 * @program: offer67
 * @description: 数组中只出现一次的数字
 * @author: Mr.kane
 * @creater: 2020-08-28 16:09
 **/


//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果


public class JZ40_findNumsAppearOnce {

    public void findNumsAppearsOnce(int [] array, int num1[] , int num2[]){

        if(array.length < 2){
            return;
        }
        int flag = 1;
        int temp = 0;
        for(int i = 0; i < array.length; i++){
            temp ^= array[i];
        }
        //找到两个不同数，第一个不相同的位数
        while((temp & flag) == 0 ){

            flag <<= 1;
        }

        for(int i = 0; i < array.length; i++){
            if((flag & array[i]) == 0){
                num2[0] ^= array[i];
            }else{
                num1[0] ^= array[i];
            }
        }

    }
}
