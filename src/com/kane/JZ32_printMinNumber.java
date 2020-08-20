package com.kane;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: offer67
 * @description: 把数组排成最小的数
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
 *
 * @author: Mr.kane
 * @creater: 2020-08-18 17:20
 **/

public class JZ32_printMinNumber {

    /***
    * @Description:
    * @Param: [numbers]
    * @return: java.lang.String
     * 解题思路：
     *  * 先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
     *  * 排序规则如下：
     *  * 若ab > ba 则 a > b，
     *  * 若ab < ba 则 a < b，
     *  * 若ab = ba 则 a = b；
     *  * 解释说明：
     *  * 比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较
     *
    * @Author: Mr.Kane
    * @Date: 2020/8/19 09:18
    */
//    public String printMinNumber(int [] numbers){
//
//        if(numbers == null || numbers.length == 0){
//            return "";
//        }
//        int len = numbers.length;
//        String[] str = new String[len];
//        StringBuffer stringBuffer = new StringBuffer();
//        for(int i = 0; i < len; i++){
//            str[i] = String.valueOf(numbers[i]);
//        }
//        Arrays.sort(str, new Comparator<String>() {
//            @Override
//            public int compare(String str1, String str2) {
//                String c1 = str1 + str2;
//                String c2 = str2 + str1;
//                return c1.compareTo(c2);
//            }
//        });
//
//        for(int i = 0; i < len; i++){
//            stringBuffer.append(str[i]);
//        }
//        return stringBuffer.toString();
//    }

    public String printMinNumber(int [] numbers){

        if(numbers == null || numbers.length == 0){
            return "";
        }
        int len = numbers.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len - i - 1; j++){
                String  str1 = String.valueOf(numbers[j]) + String.valueOf(numbers[j + 1]);
                String  str2 = String.valueOf(numbers[j + 1]) + String.valueOf(numbers[j]);
                if(str1.compareTo(str2) > 0){
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        String string = String.valueOf(numbers[0]);
        for(int i = 1; i < len; i++){
            string += String.valueOf(numbers[i]);
        }
        return string;
    }

}
