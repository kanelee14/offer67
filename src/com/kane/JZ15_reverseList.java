package com.kane;

import java.util.Stack;

/**
 * @program: offer67
 * @description: 反转链表
 * 输入一个链表，反转链表后，输出新链表的表头。
 * @author: Mr.kane
 * @creater: 2020-07-30 15:35
 **/

public class JZ15_reverseList {

    //运用stack 可能存在运行时间过长
//    public  ListNode reverseList(ListNode head){
//
//        Stack<ListNode> stack = new Stack<>();
//        ListNode reverseHead = null;
//        ListNode current = head;
//
//        if(head == null){
//            return head;
//        }
//        while (current != null){
//            stack.push(current);
//            current = current.next;
//        }
//        reverseHead = stack.pop();
//        System.out.println("反转后head值:  " + reverseHead.val);
//        while( !stack.isEmpty()){
//             reverseHead.next = stack.pop();
//             System.out.println(reverseHead.next.val);
//        }
//        return reverseHead;
//


    public ListNode reverseList(ListNode head){

        if(head == null){
            return  head;
        }
        //当前节点是head，pre为当前节点的前一节点，next为当前节点的下一节点
        //需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
        //即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了
        //所以需要用到pre和next两个节点
        //1->2->3->4->5
        //1<-2<-3 4->5
        ListNode reverseHead = null;
        ListNode  current = head;
        ListNode temp = null;
        ListNode pre = null;
        while(current != null){
            //做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre
            //如此就可以做到反转链表的效果
            //先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
            temp = current.next;
            //保存完next，就可以让head从指向next变成指向pre了，代码如下
            current.next = pre;
            //如果head为null的时候，pre就为最后一个节点了(链表已经反转完毕，pre就是反转后链表的第一个节点)
            if(temp == null){
               reverseHead = current;
            }
            //head指向pre后，就继续依次反转下一个节点
            //让pre，head，next依次向后移动一个节点，继续下一次的指针反转
            pre = current;
            current = temp;
        }
/*        while (reverseHead != null){
            System.out.println(reverseHead.val);
            reverseHead = reverseHead.next;
        }*/
      //直接输出pre就是我们想要得到的反转后的链表
        return  reverseHead;
    }


    public static void main(String[] args) {

        ListNode listNode = new ListNode(0);
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(3);
        listNode.next = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;

        JZ15_reverseList jz15_reverseList = new JZ15_reverseList();
        jz15_reverseList.reverseList(listNode);

    }

}
