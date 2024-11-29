/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>(); // Map to store numbers and their indices
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Calculate complement
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i }; // Return indices if complement exists
            }
            numMap.put(nums[i], i); // Store the current number and its index
        }
        throw new IllegalArgumentException("No two sum solution"); // No solution case
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example Input Case
        int[] nums = {2, 7, 11, 15}; // Input array
        int target = 9; // Target value

        // Call the twoSum method
        int[] result = solution.twoSum(nums, target);

        // Print the result
        System.out.println("Indices of numbers that add up to the target:");
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}
