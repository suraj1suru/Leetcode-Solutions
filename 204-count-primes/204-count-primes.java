class Solution {
    public int countPrimes(int n) {
    int count = 0;
        if(n==0 || n == 1) return 0;
         boolean [] prime = new boolean[n];
    
     for(int i =2; i<n; i++){
          prime[i] = true;
        }    
        
    for(int i = 2; i <= Math.sqrt(n); i++){  
        if(prime[i] == true){
            for(int j = i *i;  j<n; j = j+i){
                prime[j] = false;
            }
        }
    }
        
       
      for(int i =0; i< n; i++){
          if(prime[i] == true){
              count++;
          }
      }  
   
    return count;
    }
}