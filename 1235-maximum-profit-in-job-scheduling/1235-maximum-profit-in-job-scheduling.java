//khud se ni kiyaa
//khud se ni kiyaa
//khud se ni kiyaa

class Job {
    public int start, end, profit;
    Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}
class Solution {
    int[] table;
    public int jobScheduling(int[] start, int[] end, int[] profit) {
        int n = start.length;
        table = new int[n];
        Arrays.fill(table, -1);
        
        Job []jobs = new Job[n];
        for(int i=0;i<n;i++) {
            jobs[i] = new Job(start[i], end[i], profit[i]);
        }
        
        Arrays.sort(jobs, (j1, j2)-> {
            return Integer.compare(j1.start,j2.start);
        });
        
        return recursiveUtil(jobs, 0, n);
    }
    private int recursiveUtil(Job[] jobs, int index, int n) {
        if(index >= n) 
            return 0;
        
        if(table[index]!=-1)
            return table[index];
        
        int include = jobs[index].profit;
        int gncj = findIndexOfNonConflictingJob(jobs, index, n);
        if(gncj!=-1)
            include += recursiveUtil(jobs, gncj , n);
        int exclude = recursiveUtil(jobs, index+1, n);
        
        return table[index] = Math.max(include, exclude);
    }
    private int findIndexOfNonConflictingJob(Job[] jobs, int index, int n) {
        for(int i=index+1;i<n;i++) {
            if(jobs[i].start >= jobs[index].end) {
                return i;
            }
        }
        return -1;
    }
}