package com.kane;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @program: offer67
 * @description:   从尾到头打印链表
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * @author: Mr.kane
 * @creater: 2020-07-24 16:29
 **/

 class ListNode{
    int val;
    ListNode next = null;

    ListNode(int val){
        this.val  = val;
    }
}

public class JZ3_printListFromTailToHead {


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer>  arrayList  = new ArrayList<>();
        while (listNode != null){
            System.out.println(listNode.val);
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.isEmpty()){
            arrayList.add(stack.pop());
            System.out.println(" 出栈并存ArrayList" + arrayList);
        }
        return  arrayList;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(3);
        listNode.next = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;

        JZ3_printListFromTailToHead jz3_printListFromTailToHead = new JZ3_printListFromTailToHead();
        ArrayList<Integer> arrayList = jz3_printListFromTailToHead.printListFromTailToHead(listNode);
        System.out.println(arrayList);
        System.out.println(arrayList.size());
    }
}
