
# Definition for a Node.
class Node(object):
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

class Solution(object):
    def cloneGraph(self, node):
        """
        :type node: Node
        :rtype: Node
        """
        if not node:
            return None

        # Dictionary to store cloned nodes
        cloned = {}

        # Helper function for DFS
        def dfs(current_node):
            # If the node is already cloned, return the cloned node
            if current_node in cloned:
                return cloned[current_node]

            # Clone the node
            copy = Node(current_node.val)
            cloned[current_node] = copy

            # Recursively clone neighbors
            for neighbor in current_node.neighbors:
                copy.neighbors.append(dfs(neighbor))

            return copy

        # Start the DFS traversal from the given node
        return dfs(node)
# Example Graph Input:
# adjList = [[2,4],[1,3],[2,4],[1,3]]
node1 = Node(1)
node2 = Node(2)
node3 = Node(3)
node4 = Node(4)
node1.neighbors = [node2, node4]
node2.neighbors = [node1, node3]
node3.neighbors = [node2, node4]
node4.neighbors = [node1, node3]

# Clone the graph
solution = Solution()
cloned_node = solution.cloneGraph(node1)

# Helper function to print the graph for verification
def print_graph(node, visited=set()):
    if not node or node in visited:
        return
    visited.add(node)
    print(f"Node {node.val}: {[n.val for n in node.neighbors]}")
    for neighbor in node.neighbors:
        print_graph(neighbor, visited)

print("Original Graph:")
print_graph(node1)

print("\nCloned Graph:")
print_graph(cloned_node)
