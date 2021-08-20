
public class App {
   
    public static void main(String[] args) throws Exception {
        System.out.println("leetcode.com 19. Remove Nth Node From End of List");


        System.out.println("Given the head of a linked list, remove the nth node from the end of the list"+
        "and return its head.");

        System.out.println("Example  1\n" + " Input: head = [1,2,3,4,5], n = 2\n" + " Output: [1,2,3,5]");

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n = 2;
        System.out.println("*** Head: ");
        Solution.printListNode(head);
        System.out.println("*** Output: ");
        Solution.printListNode((new Solution()).removeNthFromEnd(head, n));

        System.out.println("Example 2:");
        head=new ListNode(1);
        n=1;

        System.out.println("Input: head = [1], n = 1");
        System.out.println("Output: []");
        //
        System.out.println("*** Head: ");

        Solution.printListNode(head);
        System.out.println("*** Output: ");
        Solution.printListNode((new Solution()).removeNthFromEnd(head, n));

        System.out.println("Example 3:");
        head=new ListNode(1,new ListNode(2));
        n=2;

        System.out.println("Input: head = [1,2], n = 2");
        System.out.println("Output: [2]");
        //
        System.out.println("*** Head: ");

        Solution.printListNode(head);
        System.out.println("*** Output: ");
        Solution.printListNode((new Solution()).removeNthFromEnd(head, n));

        // Constraints:

        // The number of nodes in the list is sz.
        // 1 <= sz <= 30
        // 0 <= Node.val <= 100
        // 1 <= n <= sz
    }
}

/**
 * Definition for singly-linked list.
 * 
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

class Solution {
    public static void printListNode(ListNode head) {
        ListNode headcopy = head;
        System.out.print("[");
        while (headcopy != null) {
            System.out.print("" + headcopy.val + "");
            headcopy = headcopy.next;
            if(headcopy!=null){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        
        for(int i=0;i < n;i++){
            fast = fast.next;
        }
        if(fast==null){
            return head.next;
        }
        
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
