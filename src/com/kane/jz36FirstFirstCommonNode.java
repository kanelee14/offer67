package com.kane;

/**
 * @program: offer67
 * @description: 两个链表的第一个公共节点
 * @author: Mr.kane
 * @creater: 2020-09-03 17:20
 **/

public class jz36FirstFirstCommonNode {

    /***
    * @Description:
    * @Param: [listNode1, listNode2]
    * @return: com.kane.ListNode
     *
     *   长度相同有公共结点，第一次就遍历到；没有公共结点，走到尾部NULL相遇，返回NULL
     *   长度不同有公共结点，第一遍差值就出来了，第二遍一起到公共结点；没有公共，一起到结尾NULL。
     *
     *
     *   假定 List1长度: a+n  List2 长度:b+n, 且 a<b
     *   那么 p1 会先到链表尾部, 这时p2 走到 a+n位置,将p1换成List2头部
     *   接着p2 再走b+n-(n+a) =b-a 步到链表尾部,这时p1也走到List2的b-a位置，还差a步就到可能的第一个公共节点。
     *   将p2 换成 List1头部，p2走a步也到可能的第一个公共节点。如果恰好p1==p2,那么p1就是第一个公共节点。  或者p1和p2一起走n步到达列表尾部，二者没有公共节点，退出循环。 同理a>=b.
     *   时间复杂度O(n+a+b)
     *
    * @Author: Mr.Kane
    * @Date: 2020/9/3 17:26
    */
    public ListNode findFristCommonNode(ListNode listNode1, ListNode listNode2){

        if(listNode1 == null || listNode2 == null){
            return null;
        }
        ListNode p1 = listNode1;
        int count1 = 0;
        while (p1 != null){
            p1 = p1.next;
            count1++;
        }
        int count2 = 0;
        ListNode p2 = listNode2;
        while(p2 != null){
            p2 = p2.next;
            count2++;
        }

        int flag = count1 - count2;
        if(flag > 0){
            while (flag > 0){
                listNode1 = listNode1.next;
                flag--;
            }
            while (listNode1 != listNode2){
                listNode1 = listNode1.next;
                listNode2 = listNode2.next;
            }
            return listNode1;
        }
        if(flag <= 0){
            while (flag < 0){
                listNode2 = listNode2.next;
                flag++;
            }
            while (listNode1 != listNode2){
                listNode1 = listNode1.next;
                listNode2 = listNode2.next;
            }
            return listNode1;
        }
        return null;
    }
}
