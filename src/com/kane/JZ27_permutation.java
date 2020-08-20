package com.kane;

import java.util.*;

/**
 * @program: offer67
 * @description: 字符串的排列
 * @author: Mr.kane
 * @creater: 2020-08-04 15:07
 **/

public class JZ27_permutation {

    public ArrayList<String> permutation(String str){
        ArrayList<String> list = new ArrayList<String>();
        if(str != null && str.length()>0){
            PermutationHelper(str.toCharArray(),0,list);
            Collections.sort(list);
        }
        return list;
    }

    private void PermutationHelper(char[] chars, int i, List<String> list){
        if(i == chars.length-1){
            String val = String.valueOf(chars);
            list.add(val);
        }else{
            Set<Character> charSet = new HashSet<Character>();
            for(int j=i;j<chars.length;++j){
                System.out.println(j);
                if( !charSet.contains(chars[j])){
                    charSet.add(chars[j]);
                    swap(chars,i,j);
                    PermutationHelper(chars,i+1,list);
                    swap(chars,j,i);

                }
            }
        }
    }
    private void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j]= temp;
    }
}
