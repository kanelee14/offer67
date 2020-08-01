package com.kane;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: offer67
 * @description: 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author: Mr.kane
 * @creater: 2020-07-30 15:33
 **/

public class JZ13_reOrderArray {

    public void reOrderArray(int [] array){

        if(array.length == 0 ){
            return;
        }
        int length = array.length;
        int[] newArray = new int[length];
        int[] tempEvenArray = new int[length];
        int temp = 0;
        int temp1 = 0;
        for(int i = 0; i < length; i++){

            if((array[i] & 1) == 1){
                newArray[temp] = array[i];
                temp++;
            }else{
                tempEvenArray[temp1] = array[i];
                temp1++;
            }
        }
        for(int i = 0; i < temp1; i++){
            newArray[length - temp1 + i ] =  tempEvenArray[i];
        }
        System.out.println(Arrays.toString(newArray));
  /*      for(int i:newArray){
            System.out.println(i);
        }  */

    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        JZ13_reOrderArray jz13_reOrderArray = new JZ13_reOrderArray();
        jz13_reOrderArray.reOrderArray(array);
    }

}
