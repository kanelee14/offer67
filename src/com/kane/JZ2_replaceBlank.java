package com.kane;

/**
 * @program: offer67
 * @description: 替换空格：
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 * @author: Mr.kane
 * @creater: 2020-07-22 17:08
 **/

public class JZ2_replaceBlank {

    public static String replaceSpace(StringBuffer str){
        int sum = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                sum++;
            }
        }

        int length = str.length() - 1;
        int length_new = length + 2*sum;
        str.setLength(length_new + 1);
        while (length >= 0 && length_new >= length){
            if(str.charAt(length) == ' '){
                str.setCharAt(length_new--,'0');
                str.setCharAt(length_new--,'2');
                str.setCharAt(length_new,'%');
            }else{
                str.setCharAt(length_new,str.charAt(length));
            }
            length--;
            length_new--;
        }
        return str.toString();
    }

    public static void main(String[] args) {

        String str = "We are Happy!";
        StringBuffer stringBuffer  = new StringBuffer();
        stringBuffer.append(str);
        // StringBuffer stringBuffer  = new StringBuffer(str);
        String str_new = replaceSpace(stringBuffer);
        System.out.println(str_new);
    }
}
