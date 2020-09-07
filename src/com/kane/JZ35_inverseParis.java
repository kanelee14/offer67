package com.kane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: offer67
 * @description: 数组中的逆序对
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 *
 * 数据范围：
 *
 * 	对于%50的数据,size<=10^4
 * 	对于%75的数据,size<=10^5
 * 	对于%100的数据,size<=2*10^5
 *
 * 	示例1
 *   输入
 *     1,2,3,4,5,6,7,0
 *   输出
 *     7
 *
 * @author: Mr.kane
 * @creater: 2020-08-21 16:19
 **/

public class JZ35_inverseParis {

//    public static int inverserParis(int [] array){
//
//        if(array == null || array.length){
//            return 0;
//        }
//        int[] tmp = new int[array.length];
//        return  mergeSort(array, tmp, 0, array.length - 1);
//    }
//
//    //归并排序，递归
//    private static int mergeSort(int [] array, int [] tmp, int low, int high){
//        if(low >= high){
//            return 0;
//        }
//        int res = 0, mid = low + (high - low) / 2;
//        res += mergeSort(array, tmp, low, mid);
//        res %= 1000000007;
//        res += mergeSort(array, tmp, mid + 1, high);
//        res %= 1000000007;
//        res += merge(array, tmp, low, mid, high);
//        res %= 1000000007;
//        return res;
//    }
//
//    //归并排序，合并
//    private static int merge(int[] array, int[] tmp, int low, int mid, int high) {
//        int i = low, i1 = low, i2 = mid + 1;
//        int res = 0;
//        while(i1 <= mid && i2 <= high) {
//            if(array[i1] > array[i2]) {
//                res += mid - i1 + 1;
//                res %= 1000000007;
//                tmp[i++] = array[i2++];
//            } else
//                tmp[i++] = array[i1++];
//        }
//        while(i1 <= mid)
//            tmp[i++] = array[i1++];
//        while(i2 <= high)
//            tmp[i++] = array[i2++];
//        for (i = low; i <= high; i++)
//            array[i] = tmp[i];
//        return res;
//    }

    /**
    * @Description:
    * @Param:
    * @return:
     *
     * 归并排序的改进，把数据分成前后两个数组(递归分到每个数组仅有一个数据项)，
     * 合并数组，合并时，出现前面的数组值array[i]大于后面数组值array[j]时；则前面
     * 数组array[i]~array[mid]都是大于array[j]的，count += mid+1 - i
     * 参考剑指Offer，但是感觉剑指Offer归并过程少了一步拷贝过程。
     * 还有就是测试用例输出结果比较大，对每次返回的count mod(1000000007)求余
     *
    * @Author: Mr.Kane
    * @Date: 2020/8/21 16:34
    */
    public int inversePairs(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int[] copy = new int[array.length];
        for(int i = 0; i < array.length; i++){
            copy[i] = array[i];
        }
        //数值过大求余
        int count = inverseParisCore(array,copy,0,array.length-1);
        return count;
    }

    private int inverseParisCore(int[] array,int [] copy, int low, int high){
        if(low == high){
            return 0;
        }
        int mid = (high + low) >> 1;
        int leftCount = inverseParisCore(array, copy, low, mid);
        int rightCount = inverseParisCore(array, copy,mid + 1, high);
        int count = 0;
        int i = mid;
        int j = high;
        int locCopy = high;
        while(i >= low && j > mid){
            if(array[i] > array[j]){
                count += j - mid;
                copy[locCopy--] = array[i--];
                if(count >= 1000000007){
                    count %= 1000000007;
                }
            }else{
                copy[locCopy--] = array[j--];
            }
        }
        for(;i>=low;i--){
            copy[locCopy--] = array[i];
        }
        for(;j>mid;j--)
        {
            copy[locCopy--] = array[j];
        }
        for(int s = low; s <= high; s++)
        {
            array[s] = copy[s];
        }
        return (leftCount+rightCount+count)%1000000007;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        JZ35_inverseParis jz35_inverseParis = new JZ35_inverseParis();
        String str = br.readLine();
        str = str.substring(1, str.length()-1);
        String[] valueArr = str.split(",");
        int[] array = new int[valueArr.length];
        for (int i = 0; i < valueArr.length; i++) {
            array[i] = Integer.parseInt(valueArr[i]);
        }

        System.out.println(jz35_inverseParis.inversePairs(array));
    }
}
