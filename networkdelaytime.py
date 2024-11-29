import heapq
from collections import defaultdict

class Solution(object):
    def networkDelayTime(self, times, n, k):
        """
        :type times: List[List[int]]
        :type n: int
        :type k: int
        :rtype: int
        """
        # Create an adjacency list to represent the graph
        graph = defaultdict(list)
        for u, v, w in times:
            graph[u].append((v, w))
        
        # Priority queue for Dijkstra's algorithm (min-heap)
        min_heap = [(0, k)]  # (time, node)
        
        # Dictionary to store the shortest time to reach each node
        distances = {i: float('inf') for i in range(1, n + 1)}
        distances[k] = 0
        
        while min_heap:
            current_time, current_node = heapq.heappop(min_heap)
            
            # If we already found a better path, continue
            if current_time > distances[current_node]:
                continue
            
            # Check neighbors of the current node
            for neighbor, travel_time in graph[current_node]:
                time = current_time + travel_time
                # If we found a shorter path to the neighbor
                if time < distances[neighbor]:
                    distances[neighbor] = time
                    heapq.heappush(min_heap, (time, neighbor))
        
        # Check if all nodes are reachable
        max_time = max(distances.values())
        return max_time if max_time < float('inf') else -1

# Example test cases
solution = Solution()
print(solution.networkDelayTime([[2,1,1],[2,3,1],[3,4,1]], 4, 2))  # Output: 2
print(solution.networkDelayTime([[1,2,1]], 2, 1))  # Output: 1
print(solution.networkDelayTime([[1,2,1]], 2, 2))  # Output: -1
