public class test {

    public static void main(String... args) {
        //System.out.println("Hello World");

        ListNode head = new ListNode(0);

        ListNode first = new ListNode(1);
        head.next = first;
        ListNode second = new ListNode(3);
        first.next = second;
        ListNode third = new ListNode(2);
        second.next = third;
        ListNode forth = new ListNode(0);
        third.next = forth;

        ListNode curr = head.next;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();

        ListNode node = insertionSortList(head);
        curr = node.next;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }


    }

    /*
     * http://www.lintcode.com/en/problem/insertion-sort-list/
     *
     */

    public static ListNode insertionSortList(ListNode head) {
        if( head == null ){
            return head;
        }

        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while( cur != null ){
            System.out.println("outer while 1: curr.val is " + cur.val);
            if (pre.next != null)
                System.out.println("outer while 2: prev.next.val is " + pre.next.val);
            next = cur.next;
            while( pre.next != null && pre.next.val < cur.val ){
                System.out.println("inner while 1: pre.val is " + pre.val);
                if (pre.next != null)
                    System.out.println("inner while 2: pre.next is " + pre.next.val);
                pre = pre.next;

            }
            //insert between pre and pre.next

            cur.next = pre.next;
            pre.next = cur;
            //System.out.println("outer while 2: prev.next.val is " + pre.next.val + "\n");
            pre = helper;
            cur = next;
            if (cur.next != null)
                System.out.println("outer while 3: curr.val is " + cur.val );
            System.out.println("outer while 4: prev.val is " + pre.val + "\n" );

        }

        return helper.next;
    }

    public static boolean findCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }

        return false;
    }


    /*
     * http://www.lintcode.com/en/problem/linked-list-cycle-ii/
     * https://leetcode.com/problems/linked-list-cycle-ii/description/
     *
     * Description: Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     *
     * Example:
     * Given -21->10->4->5, tail connects to node index 1，return 10
     *
     */
    public static ListNode findCycleII(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean isCircle = false;

        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            if (slow == fast) {
                isCircle = true;
                break;
            }

        }

        if(!isCircle) {
            return null;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    /*
     * http://www.lintcode.com/en/problem/insert-into-a-cyclic-sorted-list/
     *
     */
    public ListNode insertCyclicSortedList(ListNode node, int x) {
        // Write your code here
        if (node == null) {
            node = new ListNode(x);
            node.next = node;
            return node;
        }

        ListNode p = node;
        ListNode prev = null;
        do {
            prev = p;
            p = p.next;
            if (x <= p.val && x >= prev.val) {
                break;
            }
            if ((prev.val > p.val) && (x < p.val || x > prev.val)) {
                break;
            }
        } while (p != node);

        ListNode newNode = new ListNode(x);
        newNode.next = p;
        prev.next = newNode;
        return newNode;
    }
    /*
     * http://www.lintcode.com/en/problem/merge-two-sorted-lists/
     * Description:
     * Merge two sorted (ascending) linked lists and return it as a new sorted list. The new sorted list should be made
     * by splicing together the nodes of the two lists and sorted in ascending order.
     *
     * Example:
     * Given 1->3->8->11->15->null, 2->null, return 1->2->3->8->11->15->null.
     *
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode lastNode = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }

        if (l1 != null) {
            lastNode.next = l1;
        } else {
            lastNode.next = l2;
        }

        return dummy.next;
    }
}
