/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

    
class Solution {
    public int fib(int n) {
        // Base cases for F(0) and F(1)
        if (n == 0) return 0;
        if (n == 1) return 1;

        // Iterative approach to find F(n)
        int a = 0; // F(0)
        int b = 1; // F(1)
        int c = 0; // F(n)

        for (int i = 2; i <= n; i++) {
            c = a + b; // F(i) = F(i-1) + F(i-2)
            a = b;     // Update F(i-2)
            b = c;     // Update F(i-1)
        }

        return c;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1
        int n1 = 2;
        System.out.println("F(" + n1 + ") = " + solution.fib(n1)); // Output: 1
        
        // Test Case 2
        int n2 = 3;
        System.out.println("F(" + n2 + ") = " + solution.fib(n2)); // Output: 2
        
        // Test Case 3
        int n3 = 4;
        System.out.println("F(" + n3 + ") = " + solution.fib(n3)); // Output: 3
    }
}
