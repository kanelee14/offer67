package com.kane;


import java.util.HashMap;

/**
 * @program: offer67
 * @description: 第一个只出现一次的字符
 *
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 *
 * @author: Mr.kane
 * @creater: 2020-08-20 23:41
 **/

public class JZ34_firstNotRepeatingChar {

//    public int firstNotRepeatingChar(String str){
//
//        if(str == null || str.length() ==0){
//            return 0;
//        }
//        // 'A' 65   'z' 122  中间共 122-65+1=58
//        int[] words = new int[58];
//        for(int i = 0; i < str.length(); i++){
//            int temp = (int) str.charAt(i) - 65;
//            words[temp] += 1;
//        }
//        for(int i = 0; i < str.length(); i++){
//            int temp = (int)str.charAt(i) - 65;
//            if(words[temp] == 1){
//                return i;
//            }
//        }
//        return -1;
//    }


    public int firstNotRepeatingChar(String str){

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            if(hashMap.containsKey(str.charAt(i))){
                int number = hashMap.get(str.charAt(i));
                hashMap.put(str.charAt(i), ++number);
            }
            else{
                hashMap.put(str.charAt(i),1);
            }
        }
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(hashMap.get(ch) == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        JZ34_firstNotRepeatingChar jz34_firstNotRepeatingChar = new JZ34_firstNotRepeatingChar();
        String str = "adadfewerfbwerrdd";
        int result = jz34_firstNotRepeatingChar.firstNotRepeatingChar(str);
        System.out.println(result);
    }
}
