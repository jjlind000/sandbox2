package org.example;

import java.util.List;

//iteratively: https://leetcode.com/problems/reverse-linked-list/submissions/833630919/
//recursively: https://leetcode.com/problems/reverse-linked-list/submissions/833642591/
public class ReverseLinkedList {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode curr = null;
        ListNode head = null;
        for (int num : nums)
        {
            if (curr == null)
            {
                 curr = new ListNode(num);
                 head = curr;
            }
            else
            {
                curr.next = new ListNode(num);
                curr = curr.next;
            }
        }

        //ListNode reversed = reverseList(head);
        ListNode reversed = reverseListRecursively(head);
        print(reversed);
    }

    public static ListNode reverseList(ListNode head)
    {
        ListNode prev = null;
        // set curr to head
        ListNode curr = head;
        if (curr == null)
            return curr;
        //ListNode next;
        while(true)
        {
            // save the next node from the head
            ListNode next = curr.next;
            // point curr.next to prev
            curr.next = prev;
            // make prev the current node
            prev = curr;
            // if there is no next node from the original list, return curr
            if (next == null)
                return curr;
            // make curr the next node from the original list
            curr = next;
        }


    }


    static ListNode reverseListRecursively (ListNode head)
    {
        //recursively;
        if (head == null)
            return head;
        if (head.next == null)
            return head;

        ListNode node = reverseList(head.next); // will call recursively; the last call will be on head = 4, head.next = 5; will return 5
        head.next.next = head;   // will drop out of here when head = 4; so 4.next = 5, 5.next = 4
        head.next = null;        // 4.next = null
        return node;             // return 4
    }

    static void print(ListNode head)
    {
        int i = 0;
        ListNode curr = head;
        while (true)
        {
            if (++i > 8)
                break;
            if (curr == null)
                break;
            System.out.println("curr.val = " + curr.val);
            curr = curr.next;
        }

        System.out.println("head.val = " + head.val);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
