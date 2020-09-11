package com.kane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @program: offer67
 * @description: 扑克牌顺子
 *
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,
 * 想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,
 * 嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,
 * 他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，
 * 否则就输出false。为了方便起见,你可以认为大小王是0
 *
 * @author: Mr.kane
 * @creater: 2020-09-09 13:24
 **/

public class Jz45IsContinuous {

//    public boolean isContinuous(int [] numbers){
//
////        if(numbers.length != 5 || numbers == null){
////            return false;
////        }
////        Arrays.sort(numbers);
////        int len = numbers.length;
////        int count = 0;
////        for(int i = 0; i < len; i++){
////            if(numbers[i] == 0){
////                count++;
////            }
////        }
////        for(int i = count; i < len - 1; i++){
////            if((numbers[i+1] == numbers[i]) && numbers[i] != 0){
////                return false;
////            }
////            if((numbers[i] + 1 + count) >= numbers[i + 1] ){
////                count -= (numbers[i + 1] - numbers[i] -1);
////            }else{
////                return false;
////            }
////
////        }
////        return true;
////    }

    public boolean isContinuous(int [] numbers){

        ArrayList<Integer> tmp = new ArrayList<Integer>();
        int count = 0;
        for (int i: numbers
             ) {
            if(i == 0){
                count++;
            }else {
                tmp.add(i);
            }
        }
        Collections.sort(tmp);
        for(int i = 0; i < tmp.size() - 1 && count >= 0; i++){
            int value = tmp.get(i + 1) - tmp.get(i);
            if(tmp.get(i).equals(tmp.get(i + 1))){
                return false;
            }
            if(tmp.get(i) + 1 + count >= tmp.get(i + 1)){
                count -= tmp.get(i + 1) - 1 - tmp.get(i);
            }else{
                return false;
            }
        }
        return true;
    }
}
