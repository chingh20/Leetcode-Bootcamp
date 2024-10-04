/* 238. Product of Array Except Self
* Prefix and suffix arrays
* code can be further optimized to use O(1) space
* Question @ https://leetcode.com/problems/product-of-array-except-self/description/
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] productSuffix = new int[nums.length];
        int[] productPrefix = new int[nums.length];
        productSuffix[nums.length - 1] = 1;
        productPrefix[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            productPrefix[i] = productPrefix[i - 1] * nums[i - 1];
            productSuffix[nums.length - 1 - i] = productSuffix[nums.length - i] * nums[nums.length - i];
        }
        int[] answers = new int[nums.length];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = productPrefix[i] * productSuffix[i];
        }
        return answers;
    }
}