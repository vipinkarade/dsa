package linkedList;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedLinkedLists
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

		ListNode head20 = new ListNode(1);
		ListNode head21 = new ListNode(2);
		ListNode head22 = new ListNode(4);
		ListNode head23 = new ListNode(5);
		head20.next = head21;
		head21.next = head22;
		head22.next = head23;

		ListNode result = mergeTwoLists(head, head20);
		List<Integer> array = new ArrayList<>();
		while(result != null)
		{
			array.add(result.val);
			result = result.next;
		}
		System.out.println(array);

	}

	private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode result = new ListNode();
		ListNode head = result;
		ListNode prevNode = null;
		while (list1 != null || list2 != null)
		{
			if (list1 == null)
			{
				result.val = list2.val;
				list2 = list2.next;
				result.next = new ListNode();
			}
			else if (list2 == null)
			{
				result.val = list1.val;
				list1 = list1.next;
				result.next = new ListNode();
			}
			else if (list1.val == list2.val)
			{
				result.val = list1.val;
				result.next = new ListNode(list2.val, new ListNode());
				result = result.next;
				list1 = list1.next;
				list2 = list2.next;
			}
			else if (list1.val < list2.val)
			{
				result.val = list1.val;
				result.next = new ListNode();
				list1 = list1.next;
			}
			else
			{
				result.val = list2.val;
				result.next = new ListNode();
				list2 = list2.next;
			}

			prevNode = result;
			result = result.next;
		}

		if (prevNode != null)
			prevNode.next = null;
		else
			head = null;
		return head;
	}
}
