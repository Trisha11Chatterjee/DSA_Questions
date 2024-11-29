/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

    
class Solution {
    public int climbStairs(int n) {
        // Base cases
        if (n == 1) return 1;
        if (n == 2) return 2;

        // Variables to keep track of the number of ways to reach the previous two steps
        int first = 1; // Number of ways to reach step 1
        int second = 2; // Number of ways to reach step 2
        int current = 0; // Number of ways to reach step n

        // Start calculating from step 3 up to n
        for (int i = 3; i <= n; i++) {
            current = first + second; // The current number of ways is the sum of the two previous steps
            first = second; // Update the first step's value to the second step's value
            second = current; // Update the second step's value to the current step's value
        }

        return current; // Return the number of ways to reach step n
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1
        int n1 = 2;
        System.out.println("Number of ways to climb " + n1 + " steps: " + solution.climbStairs(n1)); // Output: 2
        
        // Test Case 2
        int n2 = 3;
        System.out.println("Number of ways to climb " + n2 + " steps: " + solution.climbStairs(n2)); // Output: 3
    }
}
