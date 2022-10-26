class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indDeg = new int[numCourses]; //index Degree Array
        List<List<Integer>> adj = new ArrayList<>(); //graph adjancy matrix
        createGraph(adj, indDeg, prerequisites);
        return bfs(adj, indDeg);
    }
    
    boolean bfs(List<List<Integer>> adj, int[] indDeg) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i =0; i<indDeg.length; i++){
            if(indDeg[i] == 0){
                q.add(i);
            }
        }
        
        int count = 0; 
        while(!q.isEmpty()){
            int rem = q.remove();
            for(int i : adj.get(rem)){
                if(--indDeg[i] == 0){
                    q.add(i);
                }
            }
            count++;
        }
        
        //if count is equal to vertces then return true beacuase all the vertces is 0 in IndDeg Array  return true if not then return false
        return count == indDeg.length;
        
    }
    
    
    void createGraph(List<List<Integer>> adj, int[] indDeg, int[][] prerequisites) {
        for (int i = 0; i < indDeg.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            // add every source to destination in graph
            // for every destination, increment index Degree count by 1
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indDeg[prerequisites[i][0]]++;
        }
    }
}
