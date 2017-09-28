public class test {

    public static void main(String... args) {
        System.out.println("Hello World");
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
}
