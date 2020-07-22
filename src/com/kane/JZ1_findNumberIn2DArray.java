package com.kane;

/**
 * @program: offer67
 * @description: 二维数组中的查找：在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * @author: Mr.kane
 * @creater: 2020-07-22 15:39
 **/

public class JZ1_findNumberIn2DArray {
    public  static boolean Find(int target, int [][] array){
        if(array.length > 0){
            int rows = array.length;
            int columns = array[0].length - 1;
            int temp = 0;
            while(temp < rows && columns >= 0){
                if(target == array[temp][columns]){
                    return true;
                }else {
                    if(array[temp][columns] > target){
                        columns--;
                    }else {
                        temp++;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        int array[][]={{1,2,3},{4,5,6},{7,9,10}};
        int target = 6;
        Boolean result = Find(target,array);
        System.out.println(result);
    }
}
