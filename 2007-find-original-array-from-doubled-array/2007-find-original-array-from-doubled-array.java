class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(changed.length % 2 != 0) return new int[0];
        Arrays.sort(changed);
        HashMap <Integer, Integer> hm = new HashMap<>();
        for(int num : changed) hm.put(num, hm.getOrDefault(num, 0)+1);
        int[] res = new int[changed.length/2];
        int pointer = 0;
        
        for(int i = 0; i<n; i++){
            if(hm.get(changed[i]) < 1) continue;
            if(hm.getOrDefault(changed[i]*2,0)<1) return new int[0];
            
            hm.put(changed[i],hm.get(changed[i])-1);            
            hm.put(changed[i]*2,hm.get(changed[i]*2)-1);
            res[pointer++]=changed[i];
            }
        
        
        return res;
    }
}