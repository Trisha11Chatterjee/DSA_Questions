/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

    
class Solution {
    public int maxArea(int[] height) {
        // Initialize two pointers, one at the beginning and one at the end of the array
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        // Move the pointers toward each other
        while (left < right) {
            // Calculate the current area formed by the lines at left and right
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            // Update maxArea if the current area is greater
            maxArea = Math.max(maxArea, currentArea);
            
            // Move the pointer pointing to the shorter line to potentially find a larger area
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        // Return the maximum area found
        return maxArea;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max area for height1: " + solution.maxArea(height1)); // Output: 49
        
        // Test Case 2
        int[] height2 = {1, 1};
        System.out.println("Max area for height2: " + solution.maxArea(height2)); // Output: 1
    }
}
