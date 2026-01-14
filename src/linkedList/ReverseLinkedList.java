package linkedList;

public class ReverseLinkedList
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

		System.out.println(reverseList(head).val);
	}

	private static ListNode reverseList(ListNode head)
	{
		if (head == null || head.next == null)
			return head;
		ListNode currNode = head.next;
		ListNode prevNode = head;
		head.next = null;
		while (currNode != null)
		{
			ListNode temp = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = temp;
		}

		return prevNode;
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
