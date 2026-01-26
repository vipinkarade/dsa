package linkedList;

public class RemoveNodeFromEndOfLinkedList
{
	static void main()
	{
		ListNode head = new ListNode(1);
		ListNode head1 = new ListNode(2);
		ListNode head2 = new ListNode(3);
		ListNode head3 = new ListNode(4);
		ListNode head4 = new ListNode(5);
		head.next = head1;
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;

		ListNode result = removeNthFromEnd(head, 2);
		while(result != null)
		{
			System.out.print(result.val + " ");
			result = result.next;
		}
	}

	private static ListNode removeNthFromEnd(ListNode head, int n) {
		int length = 0;
		ListNode dummy = head;
		while(dummy != null)
		{
			dummy = dummy.next;
			length++;
		}

		if (length <= 1)
			return null;

		dummy = head;
		int index = length - n - 1;

		if (index < 0)
			return head.next;

		while(index > 0)
		{
			dummy = dummy.next;
			index--;
		}
		dummy.next = dummy.next.next;
		return head;
	}
}
