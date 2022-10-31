class Solution {

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
            reverse(nums, 0, nums.length - 1);
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
}
