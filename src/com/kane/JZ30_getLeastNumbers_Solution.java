package com.kane;

import java.util.ArrayList;

/**
 * @program: offer67
 * @description: 最小的K个数
 * @author: Mr.kane
 * @creater: 2020-08-04 15:08
 **/

public class JZ30_getLeastNumbers_Solution {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> output = new ArrayList<Integer>();
        if(k == 0 ||k >input.length){
            return output;
        }
        int len = input.length;
        for(int i=0; i< k; i++){
            for(int j=i;j<len;j++){
                if(input[i] >input [j]){
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
            output.add(input[i]);
        }
        return output;
    }

}
