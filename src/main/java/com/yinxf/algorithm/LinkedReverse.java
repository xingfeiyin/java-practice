package com.yinxf.algorithm;

/**
 * @author yinxf
 * @Date 2021/6/30
 * @Description 链表反转
 * 输入：1,2,3,4,5
 * 输出：5,4,3,2,1
 *
 **/
public class LinkedReverse {

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 方法一：遍历法
     * @param node
     * @return
     */
    public static ListNode iterator(ListNode node){
        ListNode prev = null ,next ;
        while (node != null){
            //1.当前节点的下一个节点赋值给next
            next = node.next ;
            //2.把前一个节点赋值给当前节点的下一个节点
            node.next = prev;
            //3.把当前节点赋值给前一个节点
            prev = node;
            //4.把当前节点的下一个节点赋值给node
            node = next ;
        }

        return prev ;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        ListNode iterator = iterator(node1);


    }

}
