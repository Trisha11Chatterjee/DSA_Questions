/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Test case 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println("Can finish courses? " + canFinish(numCourses1, prerequisites1));

        // Test case 2
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("Can finish courses? " + canFinish(numCourses2, prerequisites2));

        // Test case 3
        int numCourses3 = 4;
        int[][] prerequisites3 = {{1, 0}, {2, 1}, {3, 2}};
        System.out.println("Can finish courses? " + canFinish(numCourses3, prerequisites3));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency list and an in-degree array
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Initialize the adjacency list
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Populate the adjacency list and in-degree array
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            adjList.get(prereq).add(course);
            inDegree[course]++;
        }

        // Initialize a queue to perform BFS
        Queue<Integer> queue = new LinkedList<>();

        // Add courses with no prerequisites (in-degree 0) to the queue
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Count of courses that can be completed
        int completedCourses = 0;

        // Perform BFS
        while (!queue.isEmpty()) {
            int current = queue.poll();
            completedCourses++;

            // Reduce the in-degree of adjacent courses
            for (int neighbor : adjList.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If all courses can be completed, return true
        return completedCourses == numCourses;
    }
}
