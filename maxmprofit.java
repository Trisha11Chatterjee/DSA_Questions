/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

    
// Solution class containing the maxProfit method
class Solution {
    public int maxProfit(int[] prices) {
        // Initialize variables for the minimum price and maximum profit
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        // Iterate through the array to find the maximum profit
        for (int i = 0; i < prices.length; i++) {
            // Update minPrice if a new lower price is found
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // Calculate the profit if sold at current price and update maxProfit if it's higher than the current maxProfit
            int profit = prices[i] - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        
        // Return the maximum profit found, or 0 if no profit is possible
        return maxProfit;
    }
}

// Main class containing the main method for program execution
public class Main {
    public static void main(String[] args) {
        // Create an instance of Solution class
        Solution solution = new Solution();
        
        // Test Case 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Max profit for prices1: " + solution.maxProfit(prices1)); // Output: 5
        
        // Test Case 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Max profit for prices2: " + solution.maxProfit(prices2)); // Output: 0
        
        // Additional Test Case 3
        int[] prices3 = {1, 2, 3, 4, 5};
        System.out.println("Max profit for prices3: " + solution.maxProfit(prices3)); // Output: 4
        
        // Additional Test Case 4
        int[] prices4 = {5, 4, 3, 2, 1};
        System.out.println("Max profit for prices4: " + solution.maxProfit(prices4)); // Output: 0
    }
}
