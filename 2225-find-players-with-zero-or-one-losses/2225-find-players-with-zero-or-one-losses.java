class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> winners = new ArrayList<>();
        ArrayList<Integer> losers = new ArrayList<>();
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i =0; i < matches.length; i++){
            map.put(matches[i][1], map.getOrDefault(matches[i][1],0) + 1); // storing frequency
        }
        
        HashSet<Integer>hs = new HashSet<>();
        
       for(int i = 0; i < matches.length; i++) {
            if(!map.containsKey(matches[i][0]) && !hs.contains(matches[i][0])){
                hs.add(matches[i][0]);
                winners.add(matches[i][0]);
            }
        }
               
          for(int key : map.keySet()) {
              if(map.get(key) == 1){
                  losers.add(key);
              }  
          } 
               
        Collections.sort(winners);
        Collections.sort(losers);
        ans.add(winners);
        ans.add(losers);      
               
               
       return ans;     
    }
}