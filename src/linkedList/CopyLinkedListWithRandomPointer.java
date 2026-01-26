package linkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyLinkedListWithRandomPointer
{
	static void main()
	{
		Node head = new Node(1);
		Node head1 = new Node(2);
		Node head2 = new Node(3);
		Node head3 = new Node(4);
		Node head4 = new Node(5);
	}

	private static Node copyRandomList(Node head)
	{
		if (head == null)
			return null;

		Map<Node, Node> map = new HashMap<>();

		Node orignal = head;
		Node copy = new Node(orignal.val);
		Node copyHead = copy;

		while (orignal != null)
		{
			map.put(orignal, copy);
			orignal = orignal.next;
			if (orignal != null)
			{
				copy.next = new Node(orignal.val);
				copy = copy.next;
			}
		}

		orignal = head;
		copy = copyHead;

		while (orignal != null)
		{
			copy.random = map.get(orignal.random);
			copy = copy.next;
			orignal = orignal.next;
		}

		return copyHead;

	}
}
