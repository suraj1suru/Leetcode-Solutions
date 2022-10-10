class Solution {
    private List<List<Integer>> buildGraph(int n, int[][] edges) {
	List<List<Integer>> graph = new ArrayList<>();

	for(int i=0;i<n;i++) {
		graph.add(new ArrayList<>());
	}

	for(int[] edge: edges) {
		graph.get(edge[0]).add(edge[1]);
		graph.get(edge[1]).add(edge[0]);
	}

	return graph;
}
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
      List<List<Integer>> graph = buildGraph(n, edges);
        
        boolean[] visited = new boolean[n];
        
        return hasPath(graph, visited, source, destination);
    }
    
    private boolean hasPath( List<List<Integer>> graph, boolean[] visited, int src, int dst){
        if(src == dst) return true;
        
        visited[src] = true;
        
        for(int neighbor: graph.get(src)){
            if(visited[neighbor] == false){
                boolean hasNbrPath= hasPath(graph, visited, neighbor, dst);
                if(hasNbrPath == true) return true;
            }
        }
          return false;
    }
  
}