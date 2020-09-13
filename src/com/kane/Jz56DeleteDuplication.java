package com.kane;

/**
 * @program: offer67
 * @description: 删除链表中重复的结点
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5
 * 处理后为 1->2->5
 *
 * @author: Mr.kane
 * @creater: 2020-09-13 14:29
 **/

public class Jz56DeleteDuplication {

    public ListNode deleteDuplication(ListNode pHead){

        if(pHead == null || pHead.next == null){
            return pHead;
        }
//
//        ListNode pre = pHead;
//        ListNode last = pHead.next;
//        ListNode head = new ListNode(0);
//        head.next = pHead;
//        while(last != null){
//            if(last.next != null && last.val == last.next.val){
//                //找到最后的一个相同结点
//                while(last.next != null && last.val == last.next.val){
//                    last = last.next;
//                }
//                pre.next = last.next;
//                last = last.next;
//            }else {
//                pre = pre.next;
//                last = last.next;
//            }
//        }
//        return head.next;

        if(pHead.val == pHead.next.val){
            //当前结点是重复结点
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val){
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                pNode = pHead.next;
            }
            // 从第一个与当前结点不同的结点开始递归
            return deleteDuplication(pNode);
        }else {
            // 当前结点不是重复结点
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }


    }
}
