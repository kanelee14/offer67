package com.kane;

/**
 * @program: offer67
 * @description: 构建乘积数组
 *
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，
 * B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 *
 * @author: Mr.kane
 * @creater: 2020-09-11 14:15
 **/

public class Jz51Multiply {

    public int[] multiply(int[] A){

        if(A.length == 0 || A == null ){
            return null;
        }

//        int[] B = new int[A.length];
//        int sum = 1;
//        for(int i = 0; i < A.length; i++){
//            sum *= A[i];
//        }
//        for(int i = 0; i < B.length; i++){
//            B[i] = sum / A[i];
//        }
//        return B;

        int length = A.length;
        int[] B = new int[length];
        if(length != 0){
            B[0] = 1;
            for(int i = 1; i < length; i++){
                B[i] = A[i - 1] * B[i - 1];
            }
            int tmp = 1;
            for(int j = length - 2; j >= 0; j--){
                tmp = tmp * A[j + 1];
                B[j] = tmp * B[j];
            }
        }
        return B;
    }
}
