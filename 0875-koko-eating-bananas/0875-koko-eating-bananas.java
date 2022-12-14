class Solution {

    public static boolean isPossible(int[] piles, int midSpeed, int h) {
        int time = 0;

        for (int i = 0; i < piles.length; i++) {
            time += (int) Math.ceil(piles[i] * 1.0 / midSpeed);
        }

        return time <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int val : piles) {
            max = Math.max(max, val);
        }

        if (h == piles.length) {
            return max;
        }

        int lo = 0;
        int hi = max;
        int speed = Integer.MAX_VALUE;
        while (lo <= hi) {
            int midSpeed = lo + (hi - lo) / 2; //avoid overflow

            if (isPossible(piles, midSpeed, h) == true) {
                speed = midSpeed;
                hi = midSpeed - 1;
            } else {
                lo = midSpeed + 1;
            }
        }
        return speed;
    }
}
