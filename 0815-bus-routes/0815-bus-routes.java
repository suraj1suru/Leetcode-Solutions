class Solution {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = routes.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int bustopno = routes[i][j];
                ArrayList<Integer> busno = map.getOrDefault(bustopno, new ArrayList<>());
                busno.add(i);
                map.put(bustopno, busno);
            }
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        HashSet<Integer> busstopvis = new HashSet<>();
        HashSet<Integer> busvis = new HashSet<>();

        q.add(source);
        busstopvis.add(source);
int level =0;
        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                int rem = q.remove();

                if (rem == target) {
                    return level;
                }

                ArrayList<Integer> buses = map.get(rem);
                for (int bus : buses) {
                    if (busvis.contains(bus) == true) {
                        continue;
                    }

                    int[] arr = routes[bus];
                    for (int busstoop : arr) {
                        if (busstopvis.contains(busstoop) == true) continue;
                    

                    q.add(busstoop);
                    busstopvis.add(busstoop);
                    }
                     busvis.add(bus);
                }
               
            }
            level++;
        }
        
        return -1;
    }
}
