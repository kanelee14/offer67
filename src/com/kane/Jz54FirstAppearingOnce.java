package com.kane;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: offer67
 * @description: 字符串中第一个不重复的字符
 *
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 *  如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * @author: Mr.kane
 * @creater: 2020-09-13 10:21
 **/

public class Jz54FirstAppearingOnce {

//    int[] count = new int[256];
//    int index = 1;
//    //Insert one char from stringstream
//    public void insert(char ch){
//        if(count[ch] == 0){
//            count[ch] = index;
//            index++;
//        }else{
//            count[ch] = -1;
//        }
//    }
//    //return the first appearence once char in current stringstream
//    public char firsrtAppearingOnce(){
//
//        int tmp = Integer.MAX_VALUE;
//        char ch = '#';
//        for(int i = 0; i < 256; i++){
//            if(count[i] != 0 && count[i] != -1 && count[i] < tmp){
//                tmp = count[i];
//                ch = (char) i;
//            }
//        }
//        return ch;
//    }

    //用有序的Map：LinkedHashMap来存放char，并且记录其出现次数
    Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
    //Insert one char from stringstream
    public void insert(char ch){
        if(!map.containsKey(ch)){
            map.put(ch,1);
        }else{
            map.put(ch,map.get(ch) + 1);
        }
    }

    //return the first appearence once char in current stringstream
    public char firstAppearingOnce(){

        for(char ch:map.keySet()){
            int count = map.get(ch);
            //目前第一个只出现一次的字符，返回
            if(count == 1){
                return ch;
            }
        }
        return '#';
    }


    public static void main(String[] args) {
        Jz54FirstAppearingOnce jz54FirstAppearingOnce = new Jz54FirstAppearingOnce();
        jz54FirstAppearingOnce.insert('g');
        jz54FirstAppearingOnce.insert('0');
//        jz54FirstAppearingOnce.insert('0');
//        jz54FirstAppearingOnce.insert('g');
//        jz54FirstAppearingOnce.insert('l');
//        jz54FirstAppearingOnce.insert('e');
        System.err.println(jz54FirstAppearingOnce.firstAppearingOnce());

    }
}
