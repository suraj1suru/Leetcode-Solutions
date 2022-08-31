class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        int rem  = sum % k;
            if(rem < 0) rem += k;
            
            if(hm.containsKey(rem)){
                count += hm.get(rem);
                hm.put(rem , hm.get(rem) +1);
            }else{
              hm.put(rem , 1);
            }
            }
        
        return count;
    }
}