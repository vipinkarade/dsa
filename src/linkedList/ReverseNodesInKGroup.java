package linkedList;

public class ReverseNodesInKGroup
{
	static void main()
	{
//		ListNode head = new ListNode(7, null);
//		ListNode head1 = new ListNode(6, null);
		ListNode head2 = new ListNode(5, null);
		ListNode head3 = new ListNode(4, head2);
		ListNode head4 = new ListNode(3, head3);
		ListNode head5 = new ListNode(2, head4);
		ListNode head6 = new ListNode(1, head5);

		System.out.println(reverseKGroup(head6, 1).printListNode());
	}

	private static ListNode reverseKGroup(ListNode head, int k)
	{
		if (!checkIfKElementsExist(head, k) || k == 1)
			return head;

		int index = 0;
		ListNode start = head;
		ListNode prevNode = null;
		while (index < k)
		{
			index++;
			ListNode temp = start.next;
			start.next = prevNode;
			prevNode = start;
			start = temp;
		}

		head.next = reverseKGroup(start, k);

		return prevNode;
	}

	private static boolean checkIfKElementsExist(ListNode head, int k)
	{
		ListNode temp = head;
		int index = 0;
		while (temp != null && index < k)
		{
			index++;
			temp = temp.next;
		}

		return index == k;
	}
}
