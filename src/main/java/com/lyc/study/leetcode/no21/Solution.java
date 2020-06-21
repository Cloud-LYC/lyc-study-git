package com.lyc.study.leetcode.no21;

import com.lyc.study.sort.ListNode;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2020/6/21
 * @time: 22:19
 * @desc: 21. 合并两个有序链表 https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 */
class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);

        ListNode l1s = l1;
        ListNode l2s = l2;


        for (int i = 3; i <= 10; i++) {
            if (i%2 == 0 ) {
                l2.next = new ListNode(i);
                l2 = l2.next;
            } else {
                l1.next = new ListNode(i);
                l1 = l1.next;
            }
        }
        ListNode result = mergeTwoListsLyc(l1s,l2s);
        while (result.next != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }


    public static ListNode mergeTwoListsLyc(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);//初始化返回结果
        ListNode temp = result;//移动节点使用
        while (l1 != null && l2 != null) {//都不为空
            if (l1.val < l2.val) { //取出每次循环的最小值放到结果内
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            } else {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }
        temp.next = l1 != null ? l1 : l2; //任意为空
        return result.next;//返回结果剔除初始化节点
    }
}
