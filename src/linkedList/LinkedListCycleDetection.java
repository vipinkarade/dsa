package linkedList;

public class LinkedListCycleDetection
{
	static void main()
	{
		ListNode head = new ListNode(0);
		ListNode head1 = new ListNode(1);
		ListNode head2 = new ListNode(2);
		ListNode head3 = new ListNode(3);
		head.next = head1;
		head1.next = head2;
		head2.next = head3;
//		head3.next = head1;

		System.out.println(hasCycle(head));
	}

	private static boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow)
				return true;
		}
		return false;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode()
		{

		}

		ListNode(int val)
		{
			this.val = val;
		}

		ListNode(int val, ListNode next)
		{
			this.val = val; this.next = next;
		}
	}
}
