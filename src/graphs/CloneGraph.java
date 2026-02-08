package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph
{
	static void main()
	{

	}

	private static Node cloneGraph(Node node)
	{
		if (node == null)
			return node;
		Map<Node, Node> map = new HashMap<>();
		Node root = new Node(node.val);
		map.put(node, root);
		cloneNode(map, node, root);
		return root;
	}

	private static void cloneNode(Map<Node, Node> map, Node node, Node root)
	{
		List<Node> clonedNeighbor = new ArrayList<>();
		for (Node neighbor : node.neighbors)
		{
			if (map.get(neighbor) == null)
			{
				map.put(neighbor, new Node(neighbor.val));
				cloneNode(map, neighbor, map.get(neighbor));
			}
			clonedNeighbor.add(map.get(neighbor));
		}
		root.neighbors = clonedNeighbor;
	}
}
