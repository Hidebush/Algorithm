package 链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author yuehuig
 *
 */
public class _206_反转链表 {
	
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		
		ListNode newHead = reverseList(head.next);
		head.next.next = head;
		head = null;
		return newHead;
    }
}
