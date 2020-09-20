package com.kane;

import java.util.LinkedList;

/**
 * @program: offer67
 * @description: 数据流中的中位数
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 * @author: Mr.kane
 * @creater: 2020-09-16 16:25
 **/

public class Jz63GetMedian {

    LinkedList<Integer> linkedList = new LinkedList<Integer>();
    public void insert(Integer num){
        if(linkedList.size() == 0 || linkedList.getFirst() > num){
            linkedList.add(num);
        }else{
            boolean insertFlag = false;
            for(Integer i: linkedList){
                if(num < i){
                    int index = linkedList.indexOf(i);
                    linkedList.add(index, num);
                    insertFlag = true;
                    break;
                }
            }
            if(!insertFlag){
                linkedList.add(num);
            }
        }
    }
    public Double getMedian(){
        if(linkedList.size() == 0){
            return null;
        }
        if(linkedList.size() % 2 == 0){
            int i = linkedList.size() / 2;
            Double result = Double.valueOf(linkedList.get(i - 1) + linkedList.get(i));
            return result / 2;
        }
        Double result = Double.valueOf(linkedList.get((linkedList.size() + 1) / 2 - 1));
        return result;
    }

    public static void main(String[] args) {
        Jz63GetMedian jz63GetMedian = new Jz63GetMedian();
        jz63GetMedian.insert(5);
        System.out.println(jz63GetMedian.getMedian());
        jz63GetMedian.insert(2);
        System.out.println(jz63GetMedian.getMedian());
        jz63GetMedian.insert(3);
        System.out.println(jz63GetMedian.getMedian());
        jz63GetMedian.insert(4);
        System.out.println(jz63GetMedian.getMedian());
        jz63GetMedian.insert(1);
        System.out.println(jz63GetMedian.getMedian());
        jz63GetMedian.insert(6);
        System.out.println(jz63GetMedian.getMedian());
        jz63GetMedian.insert(7);
        System.out.println(jz63GetMedian.getMedian());
        jz63GetMedian.insert(0);
        System.out.println(jz63GetMedian.getMedian());
        jz63GetMedian.insert(8);
        System.out.println(jz63GetMedian.getMedian());
    }
}
