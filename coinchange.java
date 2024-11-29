/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

    
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test cases
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("Test 1: " + solution.coinChange(coins1, amount1)); // Output: 3 (5 + 5 + 1)

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("Test 2: " + solution.coinChange(coins2, amount2)); // Output: -1

        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println("Test 3: " + solution.coinChange(coins3, amount3)); // Output: 0
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        // Initialize a DP array with a size of (amount + 1), filled with a large value
        int[] dp = new int[amount + 1];
        // Base case: 0 amount requires 0 coins
        dp[0] = 0;
        
        // Set the initial value for all other amounts to be a large value (amount + 1)
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        
        // Update the DP array using the available coin denominations
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        
        // If dp[amount] is still the initial large value, it means we cannot form the amount
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
