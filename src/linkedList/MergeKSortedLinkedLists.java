package linkedList;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLinkedLists
{
	static void main()
	{
		ListNode head12 = new ListNode(5);
		ListNode head11 = new ListNode(3, head12);
		ListNode head1 = new ListNode(1, head11);
		ListNode head22 = new ListNode(6);
		ListNode head21 = new ListNode(4, head22);
		ListNode head2 = new ListNode(2, head21);
		ListNode[] lists = new ListNode[]{head1, head2, null, null};
		ListNode result = mergeKLists1(lists);
		printListNode(result);
	}

	private static String printListNode(ListNode result)
	{
		List<Integer> array = new ArrayList<>();
		while(result != null)
		{
			array.add(result.val);
			result = result.next;
		}
		System.out.println(array);
		return array.toString();
	}

	private static ListNode mergeKLists(ListNode[] lists)
	{
		if (lists == null)
			return new ListNode();

		ListNode result = new ListNode(-1);
		for (int i = 0; i < lists.length; i++)
		{
			ListNode head = result;
			ListNode currNode = lists[i];
			while (currNode != null)
			{
				if (head.next == null)
				{
					head.next = new ListNode(currNode.val);
				}
				else
				{
					while (head.next != null && currNode.val > head.next.val)
					{
						head = head.next;
					}

					if (head.next == null)
						head.next = new ListNode(currNode.val);
					else
					{
						ListNode temp = head.next;
						head.next = new ListNode(currNode.val, temp);
					}
				}
				head = head.next;
				currNode = currNode.next;
			}
		}
		return result.next;
	}

	private static ListNode mergeKLists1(ListNode[] lists)
	{
		if (lists == null || lists.length == 0)
			return null;

		ListNode head = lists[0];
		lists[0] = new ListNode(-1, head);
		head = lists[0];
		boolean allNodesEmpty = false;

		while (!allNodesEmpty)
		{
			allNodesEmpty = true;
			for (int i = 1; i < lists.length; i++)
			{
				if (lists[i] != null)
				{
					allNodesEmpty = false;
					if (head.next == null)
					{
						head.next = lists[i];
						lists[i] = null;
					}
					else if (head.next.val >= lists[i].val)
					{
						ListNode temp = head.next;
						head.next = lists[i];
						lists[i] = lists[i].next;
						head.next.next = temp;
					}
				}
			}
			head = head.next;
		}

		return lists[0].next;
	}
}
