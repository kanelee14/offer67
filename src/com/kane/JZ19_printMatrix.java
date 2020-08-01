package com.kane;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @program: offer67
 * @description: 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
 * 如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @author: Mr.kane
 * @creater: 2020-07-30 15:38
 **/

public class JZ19_printMatrix {

    public ArrayList<Integer> printMatrix(int [][] matrix){

        ArrayList<Integer>  result = new ArrayList<>();
        if(matrix.length == 0 || matrix == null || matrix[0].length ==0){
            return result;
        }

        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while(true){
            //最上面一层
            for(int col = left; col <= right; col++){
                result.add(matrix[up][col]);
            }
            //下下逼近
            up++;
            //判断是否越界；
            if(up > down){
                break;
            }
            //最右边一行
            for(int row = up; row <= down; row ++){
                result.add(matrix[row][right]);
            }
            //向左逼近
            right--;
            if(left > right){
                break;
            }
            for(int col = right; col >= left; col --){
                result.add(matrix[down][col]);
            }
            down--;
            //向上逼近
            if(up > down){
                break;
            }
            //最左边一行
            for(int row = down; row >= up;row--){
                result.add(matrix[row][left]);
            }
            left++;
            if(left > right){
                break;
            }

        }
        return result;
    }

    public static void main(String[] args) {

        int[][] arrays = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        JZ19_printMatrix jz19_printMatrix = new JZ19_printMatrix();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList = jz19_printMatrix.printMatrix(arrays);
        System.out.println(arrayList);
    }
}
