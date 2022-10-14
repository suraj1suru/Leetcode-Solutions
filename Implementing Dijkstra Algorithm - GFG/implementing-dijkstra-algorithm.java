//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends

class Solution
{
    public static class Pair implements Comparable<Pair>{
        int vtx,wsf;
        Pair(int vtx,int wsf){
            this.vtx = vtx;
            this.wsf = wsf;
        }
        public int compareTo(Pair o){
            return this.wsf - o.wsf;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int vtces = adj.size();
        int[] ans = new int[vtces];
        Arrays.fill(ans,-1);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(S,0));
        while(pq.size() > 0)
        {
            Pair rem = pq.remove();
            
            if(ans[rem.vtx] == -1){
                ans[rem.vtx] = rem.wsf;
                
                ArrayList<ArrayList<Integer>> edges = adj.get(rem.vtx);
                
                for(ArrayList<Integer> edge : edges){
                    int wt = edge.get(1);
                    int nbr = edge.get(0);
                
                    if(ans[nbr] == -1){
                        pq.add(new Pair(nbr,rem.wsf+wt));
                    }
                }
            }
        }
        return ans;
    }
}
