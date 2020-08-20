package com.kane;

/**
 * @program: offer67
 * @description: 复杂链表的复制
 *
 * 输入一个复杂链表
 * （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
 * 请对此链表进行深拷贝，并返回拷贝后的头结点。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 *  解题思路：
 *  1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
 *  2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
 *  3、拆分链表，将链表拆分为原链表和复制后的链表
 *
 *
 * @author: Mr.kane
 * @creater: 2020-08-04 15:06
 **/

class RandomListNode{
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label){
        this.label = label;
    }
}

public class JZ25_cloneList {

    public  RandomListNode clone(RandomListNode pHead){

        if(pHead == null){
            return null;
        }

        RandomListNode currentNode = pHead;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面
        while(currentNode != null){
            //用老节点的值申请一个新节点
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            //将新节点的next链上老节点的nex
            cloneNode.next = currentNode.next;
            //将新节点插在老节点后面
            currentNode.next = cloneNode;
            //遍历下一个结点（由于已经插入了新节点，因此遍历下一个老节点得走2个next）
            currentNode = cloneNode.next;
        }

        currentNode = pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while(currentNode != null){
            //currentNode->random是老节点的random域，再指向next就是该老节点对应的新节点应该指向的对应的random域
            currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
            //只走老节点(为其对应的新节点链上对应的randoum域)
            currentNode = currentNode.next.next;
        }
        //3、拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;
        //新链表的头是老链表头的下一个(之前复制了的)
        RandomListNode pCloneHead = pHead.next;
        while(currentNode != null){
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = currentNode.next.next;
            cloneNode.next = cloneNode.next == null?null:cloneNode.next.next;
            currentNode = currentNode.next;
        }

        return pHead;
    }
}
