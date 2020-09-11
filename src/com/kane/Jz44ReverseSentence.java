package com.kane;

/**
 * @program: offer67
 * @description: 翻转单词顺序列
 *
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * @author: Mr.kane
 * @creater: 2020-09-09 12:28
 **/

public class Jz44ReverseSentence {

    public String reverseSentence(String str){

        if(str == null || str.length() == 0){
            return str;
        }

        char[] chars = str.toCharArray();
        reverse(chars, 0, str.length());
        int temp = -1;
        for(int i = 0; i < str.length(); i++){
            if(chars[i] == ' '){
                int tempNext = i;
                reverse(chars, temp + 1, tempNext - 1);
                temp = tempNext;
            }
        }
        reverse(chars, temp + 1, str.length() - 1);
        return  chars.toString();
    }

    public void reverse(char[] chars, int begin, int end){

        if(begin < end){
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            begin++;
            end--;
        }

    }


//    public String ReverseSentence(String str) {
//        if(str == null || str.length() == 0 || str.trim().length() == 0){
//            return str;
//        }
//        StringBuffer sb = new StringBuffer();
//        String[] s = str.trim().split(" ");
//        for(int i = s.length -1; i >= 0; i--){
//            if(s[i] != ""){
//                sb.append(s[i]);
//            }
//            if(i - 1 >= 0){
//                sb.append(" ");
//            }
//        }
//        return sb.toString();
//    }
}
