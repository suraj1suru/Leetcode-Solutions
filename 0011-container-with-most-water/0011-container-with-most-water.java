class Solution {
    public int maxArea(int[] height) {
     int i = 0;
     int j = height.length - 1;
    
     int waterStore = 0;   
        
     while(i < j){
         //calculating the area
         int width = j - i;
         //calculate the max height to lines
         int h = Math.min(height[i], height[j]);
         //area to store the water
         waterStore = Math.max(waterStore , h * width);
         
         if(height[i] < height[j]){
             i++;
         }else{
             j--;
         }
     }
        
        return waterStore;
    }
}