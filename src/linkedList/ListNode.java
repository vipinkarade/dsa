package linkedList;

import java.util.ArrayList;
import java.util.List;

public class ListNode
{
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

	public String printListNode()
	{
		ListNode result = this;
		List<Integer> array = new ArrayList<>();
		while(result != null)
		{
			array.add(result.val);
			result = result.next;
		}
		return array.toString();
	}
}
