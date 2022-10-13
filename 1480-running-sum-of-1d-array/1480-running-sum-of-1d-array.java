class Solution {
    public int[] runningSum(int[] nums) {
        int[] ans  = new int[nums.length];
         int sum = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                ans[i] = nums[i];
               
            }else{
                sum  += nums[i];
                ans[i] = sum;
            }
        }
        return ans;
    }
}