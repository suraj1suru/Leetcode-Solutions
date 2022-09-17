class Solution {
    public boolean canCross(int[] stones) {
      HashMap<Integer, HashSet<Integer>>   map = new HashMap<>();
        //add all stone positions in a hashmap along with a hashset as a value for each of them.  
        
        for(int i = 0; i < stones.length; i++){
            map.put(stones[i], new HashSet<>());
        }
        
        map.get(0).add(1);//given in constraints
        
        for(int i = 0; i < stones.length; i++){
            int currentStone = stones[i];
            HashSet <Integer> jumps = map.get(currentStone);
            
            //explore all possible jumps from the currentstone
            for(int jump: jumps){
               int pos = currentStone + jump;
               if(pos == stones[stones.length - 1]) return true;
               if (map.containsKey(pos)) {
                    map.get(pos).add(jump);
                    map.get(pos).add(jump+1);
                    if (jump-1 > 0) {
                        map.get(pos).add(jump-1);
               }
            }
        }
     }
            return false;
    }
}