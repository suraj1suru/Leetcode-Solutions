class Solution {

    public int[] intToArray(int n) {
        char[] carr = Integer.toString(n).toCharArray();
        int[] arr = new int[carr.length];
        for (int i = 0; i < carr.length; i++) {
            arr[i] = Integer.parseInt(carr[i] + "");
        }
        return arr;
    }

    public long arrayToInt(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int v1 : arr) {
            sb.append("" + v1);
        }

        return Long.parseLong(sb.toString());
    }

    public void reverse(int[] nums, int low, int high) {
        while (low < high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }

    public void nextPermutation(int[] nums) {
        int i = -1;
        for (int ind = nums.length - 2; ind >= 0; ind--) {
            if (nums[ind] < nums[ind + 1]) {
                i = ind;
                break;
            }
        }

        if (i == -1) {
            //do nothing
        } else {
            int j = -1;
            for (int ind = nums.length - 1; ind >= i; ind--) {
                if (nums[ind] > nums[i]) {
                    j = ind;
                    break;
                }
            }

            int swap = nums[i];
            nums[i] = nums[j];
            nums[j] = swap;

            reverse(nums, i + 1, nums.length - 1);
        }
    }

    public int nextGreaterElement(int n) {
        int[] ans = intToArray(n);
        nextPermutation(ans);
        long v1 = arrayToInt(ans);
        if(v1 == n || v1 > Integer.MAX_VALUE) return -1;
        
        return (int)v1;
    }
}
