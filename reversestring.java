/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

    
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(s1);
        System.out.println("Reversed string: " + new String(s1)); // Output: "olleh"

        // Test case 2
        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        solution.reverseString(s2);
        System.out.println("Reversed string: " + new String(s2)); // Output: "hannaH"
    }
}

class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            // Swap characters at left and right pointers
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            // Move the pointers towards the center
            left++;
            right--;
        }
    }
}
