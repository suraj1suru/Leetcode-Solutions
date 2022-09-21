//https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/discuss/2215782/Visual-Explanation-%2B-Interview-Tips-or-JAVA
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int operations = 0, mid = nums[nums.length / 2];
        for (int num : nums) operations += Math.abs(mid - num);
        return operations;
    }
}
