package com.kane;

/**
 * @program: offer67
 * @description: 合并两个排序的链表
 * @author: Mr.kane
 * @creater: 2020-07-30 15:36
 **/

public class JZ16_merge {


    //递归
    public ListNode merge(ListNode list1, ListNode list2){

        if(list1 == null ){
            System.out.println(list2.val);
            return list2;
        }
        if(list2 == null){
            System.out.println(list1.val);
            return list1;
        }


        if(list1.val > list2.val){

            System.out.println(list2.val);
            list2.next =  merge(list1,list2.next);
            return list2;
        }else{
            System.out.println(list1.val);
            list1.next = merge(list1.next,list2);;
            return list1;
        }

    }

/*
    public ListNode merge(ListNode list1, ListNode list2){

        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        //新建一个头节点，用来存合并的链表。
        ListNode mergeHead = null;
        ListNode current = null;
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                if(mergeHead == null){
                    mergeHead = current = list1;
                }else{
                   // current.next = list1;是把list1接上。直接等于的话相当于current从原来的结点跳到了list1
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            }else{
                if(mergeHead == null){
                    mergeHead = current = list2;
                }else{
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }
        //把未结束的链表连接到合并后的链表尾部
        if(list1 != null){
            current.next = list1;
        }
        if(list2 != null){
            current.next = list2;
        }
        while (mergeHead != null){
            System.out.println(mergeHead.val);
            mergeHead = mergeHead.next;
        }

        return mergeHead;
    }*/

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(0);
        ListNode firstNode = new ListNode(3);
        ListNode secondNode = new ListNode(5);
        ListNode thirdNode = new ListNode(7);
        listNode1.next = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;

        ListNode listNode2 = new ListNode(4);
        ListNode firstNode1 = new ListNode(5);
        ListNode secondNode1 = new ListNode(6);

        listNode2.next = firstNode1;
        firstNode1.next = secondNode1;

        JZ16_merge jz16_merge = new JZ16_merge();
        jz16_merge.merge(listNode1,listNode2);
    }

}
