class Solution {

    public int longestPalindrome(String[] words) {
        int n = words.length;
        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hm.put(words[i], hm.getOrDefault(words[i], 0) + 1);
        }
    System.out.print(hm);
        int ans = 0;
        int flag = 0;

        for (String key : hm.keySet()) {
            String temp = key;
            String temp2 = "" + temp.charAt(1) + temp.charAt(0);

            //if reverse word is present
            if (hm.containsKey(temp2)) {
                //if reverse word is same(ex. "ll", "cc","aa")
                if (temp.equals(temp2)) {
                    //if freq is even for after reverse if same
                    if (hm.get(key) % 2 == 0) {
                        ans = ans + hm.get(key) * 2;
                    } else { //if freq is odd
                        ans = ans + ((hm.get(key) - 1) * 2);
                        flag = 1; //indicates there is atleast one already palindrome word with odd freq
                    }
                } else { //if reverse word exist and is not same(ex."ab"->"ba")
                    ans = ans + (Math.min(hm.get(temp), hm.get(temp2)) * 4);
                    hm.put(temp, 0);
                    hm.put(temp2, 0);
                }
            }
        }

        //put one already palindrome word at centre having odd frequency
        if (flag == 1) {
            ans = ans + 2;
        }
        return ans;
    }
}
