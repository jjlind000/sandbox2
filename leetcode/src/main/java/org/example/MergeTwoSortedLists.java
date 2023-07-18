package org.example;

public class MergeTwoSortedLists {

    public static void main(String[] args)
    {
        foo();
    }

    //https://leetcode.com/problems/merge-two-sorted-lists/submissions/
    private static void foo()
    {

    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode curr;
        if (list1.val <= list2.val)
        {
            curr = list1;
            list1 = list1.next;
        }
        else
        {
            curr = list2;
            list2 = list2.next;
        }

        ListNode head = curr;


        while (true)
        //return head;
        {
            if (list1 != null && list2 != null)
            {
                if (list1.val <= list2.val)
                {
                    // System.out.println("1: " + list1.val);
                    // System.out.println("curr.val: " +curr.val);
                    curr.next = list1;
                    list1 = list1.next;
                }
                else
                {
                    // System.out.println("2: " + list2.val)   ;
                    // System.out.println("curr.val: " +curr.val);
                    curr.next = list2;
                    list2 = list2.next;
                }
                curr = curr.next;
            }
            else if (list1 == null)
            {
                // System.out.println("3: " + list2.val)    ;
                // System.out.println("curr.val: " +curr.val);
                curr.next = list2;
                return head;
                //break;
            }
            else // list2.next == null
            {
                // System.out.println("4: " + list1.val)      ;
                // System.out.println("curr.val: " +curr.val);
                curr.next = list1;
                return head;
            }
        }
    }
}