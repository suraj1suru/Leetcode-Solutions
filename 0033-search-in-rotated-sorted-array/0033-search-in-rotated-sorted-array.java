class Solution {

    public int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[low] <= arr[mid]) {
                //low to mid part is sorted
                if (target >= arr[low] && arr[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (arr[mid] <= arr[high]) {
                //mid to high part is sorted
                if (target > arr[mid] && arr[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
