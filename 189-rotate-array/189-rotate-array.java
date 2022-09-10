class Solution {
    public void rotate(int[] nums, int k) {
      int n = nums.length; 
    
    if(k> n){
        k = k%n;
    }
    
    //Rotate left
    swap(nums.length-k,nums.length-1,nums);
    
    //Rotate Right 
    swap(0,nums.length-1-k,nums);
    
    //Rotate All
     swap(0,nums.length-1,nums);
    }
    
     public static void swap(int start, int end, int[] nums){
        while(start<=end){
        int temp = nums[start]; 
        nums[start] = nums[end];
        nums[end] = temp;
        start++; 
        end--; 
    }
           }
}

//nums = [1,2,3,4,5,6,7], k = 3