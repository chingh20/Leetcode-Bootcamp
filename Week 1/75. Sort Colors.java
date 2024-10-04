/*
 * 75. Sort Colors
 * Two pointers approach
 * Question @ https://leetcode.com/problems/sort-colors/description/
 */

class Solution {
    public void sortColors(int[] nums) {
        int leftB = 0;
        int rightB = nums.length - 1;
        int current = 0;
        while (current <= rightB) {
            if (nums[current] == 2) {
                nums[current] = nums[rightB];
                nums[rightB] = 2;
                rightB--;
            } else if (nums[current] == 0) {
                nums[current] = nums[leftB];
                nums[leftB] = 0;
                if (current == leftB) {
                    current++;
                }
                leftB++;
            } else {
                current++;
            }
        }

    }
}