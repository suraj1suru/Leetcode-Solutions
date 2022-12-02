class Solution {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        //for operation 2. i can check for the occurences as aacabb -> bbcbaa
        //here a=3 and b=2 at first then it changes to a=2 and b=3. so swapping is done
        //and for operation 1 it is always possivle
        //determine the frequency
        //sort the array and check the equality,

        int a[] = new int[26];
        int b[] = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            a[word1.charAt(i) - 'a']++;
            b[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((a[i] == 0 && b[i] != 0) || (a[i] != 0 && b[i] == 0)) return false;
        }
        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }
}
