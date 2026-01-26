package linkedList;

public class AddTwoNumbers
{
	static void main()
	{

	}

	private static ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		ListNode head = l1;

		boolean over = false;
		while (l1 != null || l2 != null || over)
		{
			int sum = l1.val + l2.val;
			if (over)
				sum++;
			over = (sum / 10) > 0;
			if (over)
				sum -= 10;
			l1.val = sum;

			if (l1.next == null && l2.next != null)
				l1.next = new ListNode(0);
			if (l2.next == null && l1.next != null)
				l2.next = new ListNode(0);
			if (l1.next == null && l2.next == null && over)
			{
				l1.next = new ListNode(0);
				l2.next = new ListNode(0);
			}

			l1 = l1.next;
			l2 = l2.next;
		}

		return head;
	}
}
