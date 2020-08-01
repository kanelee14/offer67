package com.kane;

import java.util.List;
import java.util.Stack;

/**
 * @program: offer67
 * @description: 链表中倒数第K个节点
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @author: Mr.kane
 * @creater: 2020-07-30 15:34
 **/


public class JZ14_findKthToTail {

    public ListNode findKthToTail(ListNode head, int k){

        if(head == null || k < 0){
            return  null;
        }
        ListNode pre = head;
        ListNode last = head;
        for(int i = 1; i < k; i++){
            if(pre.next != null){
                pre = pre.next;
            }else{
                return  null;
            }
        }
        while(pre.next != null){
            pre = pre.next;
            last = last.next;
        }
        System.out.println(last.val);
        return last;
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(0);
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(3);
        listNode.next = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        JZ14_findKthToTail jz14_findKthToTail = new JZ14_findKthToTail();
        jz14_findKthToTail.findKthToTail(listNode,3);

    }
}
