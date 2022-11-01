class Solution {

    public int climbStairs(int n) {
        //to store the value of recursive call
        int[] dp = new int[n + 1];
        return countSteps(n, dp);
    }

    static int countSteps(int n, int[] dp) {
        //BASE CASE
        //I can only jump on the last stair can't go next
        if (n == 0) {
            return 1;
        }
        //I can go till 0th stair from 1st stair
        if (n == 1) {
            return 1;
        }

        //to check if I have computed this value earlier or not!
        if (dp[n] != 0) {
            return dp[n];
        }
        //I can either jump one step or two step!
        int lh = countSteps(n - 1, dp);
        int rh = countSteps(n - 2, dp);

        //sum of both side
        return dp[n] = lh + rh;
    }
}
