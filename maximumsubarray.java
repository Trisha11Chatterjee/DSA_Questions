/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

    
class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize variables for the maximum sum and current sum
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Update currentSum to include the current element or start a new subarray
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Update maxSum if currentSum is greater than maxSum
            maxSum = Math.max(maxSum, currentSum);
        }
        
        // Return the maximum sum found
        return maxSum;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max subarray sum for nums1: " + solution.maxSubArray(nums1)); // Output: 6
        
        // Test Case 2
        int[] nums2 = {1};
        System.out.println("Max subarray sum for nums2: " + solution.maxSubArray(nums2)); // Output: 1
        
        // Test Case 3
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Max subarray sum for nums3: " + solution.maxSubArray(nums3)); // Output: 23
    }
}
