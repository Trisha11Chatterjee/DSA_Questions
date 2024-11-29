/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

    
class Solution {
    public void rotate(int[] nums, int k) {
        // Handle the case when k is larger than the length of the array
        k = k % nums.length;
        
        // Reverse the entire array
        reverse(nums, 0, nums.length - 1);
        // Reverse the first k elements
        reverse(nums, 0, k - 1);
        // Reverse the remaining elements
        reverse(nums, k, nums.length - 1);
    }
    
    // Helper method to reverse a subarray from start to end
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        solution.rotate(nums1, k1);
        System.out.println("Rotated array 1: " + java.util.Arrays.toString(nums1)); // Output: [5, 6, 7, 1, 2, 3, 4]
        
        // Test Case 2
        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        solution.rotate(nums2, k2);
        System.out.println("Rotated array 2: " + java.util.Arrays.toString(nums2)); // Output: [3, 99, -1, -100]
    }
}
